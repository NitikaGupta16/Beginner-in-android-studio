package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class checklist extends AppCompatActivity {
    public static final String ADD_ITEM="com.example.android.shoppingapp.add.ITEM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
    }
    public void returnItem(View view) {
        Button b=(Button)view;
        String Item = b.getText().toString();
        Intent replyIntent=new Intent();
        replyIntent.putExtra("ADD_ITEM",Item);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}