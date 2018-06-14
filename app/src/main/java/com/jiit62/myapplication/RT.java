package com.jiit62.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.TextView;


public class RT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rt);
        Intent intent = getIntent();
        timere(intent);

    }
     public void timere(Intent intent)
     {
         final TextView textView = (TextView)findViewById(R.id.timer);
            final int session =intent.getIntExtra("sessions",0);
            final int runT =intent.getIntExtra("runTime",0)*60*1000;
         final int counter = runT / 1000;
            final int Break =intent.getIntExtra("Break",0)*60*1000;
            CountDownTimer count= new  CountDownTimer(runT, 1000){
                    int timerc = 0;
                    public void onTick(long millisUntilFinished){
                    textView.setText(String.valueOf(counter-timerc));
                        timerc++;
            }
                public  void onFinish()
                {
                    textView.setText("FINISH!!");
                }
            };
            count.start();

    }
    }




