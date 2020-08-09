package com.example.shoppingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private EditText mLocationEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationEditText = findViewById(R.id.location_edit);
    }

    /*@Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("");
    }*/

    public void launchChecklist(View view) {
        Log.d(LOG_TAG,"Button Clicked!");
        Intent intent = new Intent(this,checklist.class);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
                String returnString = data.getStringExtra("ADD_ITEM");
                TextView textView1 = (TextView) findViewById(R.id.list_item1);
                TextView textView2 = (TextView) findViewById(R.id.list_item2);
                TextView textView3 = (TextView) findViewById(R.id.list_item3);
                TextView textView4 = (TextView) findViewById(R.id.list_item4);
                TextView textView5 = (TextView) findViewById(R.id.list_item5);
                TextView textView6 = (TextView) findViewById(R.id.list_item6);
                TextView textView7 = (TextView) findViewById(R.id.list_item7);
                TextView textView8 = (TextView) findViewById(R.id.list_item8);
                TextView textView9 = (TextView) findViewById(R.id.list_item9);
                TextView textView10 = (TextView) findViewById(R.id.list_item10);

                if(textView1.getText().toString().matches("")) {
                    // Set text view with string
                    textView1.setText(returnString);
                }
                else if(textView2.getText().toString().matches("")) {
                    // Set text view with string
                    textView2.setText(returnString);
                }
                else if(textView3.getText().toString().matches("")) {
                    // Set text view with string
                    textView3.setText(returnString);
                }
                else if(textView4.getText().toString().matches("")) {
                    // Set text view with string
                    textView4.setText(returnString);
                }
                else if(textView5.getText().toString().matches("")) {
                    // Set text view with string
                    textView5.setText(returnString);
                }
                else if(textView6.getText().toString().matches("")) {
                    // Set text view with string
                    textView6.setText(returnString);
                }
                else if(textView7.getText().toString().matches("")) {
                    // Set text view with string
                    textView7.setText(returnString);
                }
                else if(textView8.getText().toString().matches("")) {
                    // Set text view with string
                    textView8.setText(returnString);
                }
                else if(textView9.getText().toString().matches("")) {
                    // Set text view with string
                    textView9.setText(returnString);
                }
                else if(textView10.getText().toString().matches("")) {
                    // Set text view with string
                    textView10.setText(returnString);
                }
            }
        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,?0q"+loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intents","Can't handle!");
        }
    }
}