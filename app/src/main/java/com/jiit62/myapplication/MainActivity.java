package com.jiit62.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buttonClicked(View v){
        Intent intent = new Intent(this,F1.class);
        startActivity(intent);

    }

    public void Practice(View v)
    {
        Intent intent = new Intent(this,P.class);
        startActivity(intent);
    }

}

