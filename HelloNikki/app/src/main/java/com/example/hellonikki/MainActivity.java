package com.example.hellonikki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE="com.example.android.hellonikki.extra.MESSAGE";
    //private TextView mMessage;
    private int mCount = 0;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount= findViewById(R.id.show_count);
        //mMessage =findViewById(R.id.show_count);
    }



    public void upCount(View view) {
        mCount++;
        if(mShowCount!=null) {
            mShowCount.setText(Integer.toString(mCount));
            findViewById(R.id.zero).setBackgroundColor(RED);
            if((mCount % 2) == 0) view.setBackgroundColor(BLUE);
            else view.setBackgroundColor(GREEN);
        }
    }

    public void callMethod(View view){
        mCount=0;
        if(mShowCount!=null) {
            mShowCount.setText(Integer.toString(mCount));
            view.setBackgroundColor(GRAY);
        }
    }

    public void launchHello(View view) {
        Log.d(LOG_TAG,"Button Clicked!");
        Intent intent=new Intent(this,ShowHello.class);
        String message = mShowCount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
