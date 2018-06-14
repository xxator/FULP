package com.jiit62.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
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
         final int runT =intent.getIntExtra("runtime",0)*60*1000;
         final int counter = runT / 1000;
         final RelativeLayout layout = (RelativeLayout)findViewById(R.id.runT);
         CountDownTimer count= new  CountDownTimer(runT, 1000){
                    int timerc = 0;
                    public void onTick(long millisUntilFinished){
                    textView.setText(String.valueOf(counter-timerc));
                        timerc++;
                        if(timerc<(counter/3))
                        {
                            layout.setBackgroundColor(Color.GREEN);
                        }
            }
                public  void onFinish()
                {
                    textView.setText("FINISH!!");
                    Button button = (Button)findViewById(R.id.start);
                    final Intent intent2=new Intent(RT.this,BT.class);
                    button.setOnClickListener(new Button.OnClickListener(){
                        public void onClick(View v){
                            final int Break =getIntent().getIntExtra("breaktime",0)*60*1000;
                            intent2.putExtra("breaktime",Break);
                            startActivity(intent2);
                        }

                    });
                }
            };
            count.start();

    }

}




