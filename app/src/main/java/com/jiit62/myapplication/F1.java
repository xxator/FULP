package com.jiit62.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class F1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1);

    }
    public void focus(View v)
    {
        Intent intentRT = new Intent(F1.this,RT.class);
        Intent intentBT = new Intent(F1.this,BT.class);
        EditText session = (EditText)findViewById(R.id.sessions);
        int sessions = Integer.parseInt(String.valueOf(session.getText()));
        EditText runT = (EditText)findViewById(R.id.runT);
        int runTime = Integer.parseInt(String.valueOf(runT.getText()));
        EditText breakT = (EditText)findViewById(R.id.Break);
        int bTime = Integer.parseInt(String.valueOf(breakT.getText()));
        int i;
        for(i=0;i<sessions;i++)
        {
            intentRT.putExtra("runtime",runTime);
            intentRT.putExtra("breaktime",bTime);
            startActivity(intentRT);
        }
        //intenti.putExtra("sessions",sessions);
        //intenti.putExtra("runTime",runTime);
        //intenti.putExtra("Break",bTime);


    }
}
