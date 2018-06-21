package com.jiit62.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class P2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);
        Intent intent = getIntent();
        func(intent);
    }

    public void func(Intent intent)
    {
        final int max,bonus,time,n;


        n=intent.getIntExtra("ques",0);
        max=intent.getIntExtra("Max",0);
        bonus  =intent.getIntExtra("Bonus",0);
        time  =intent.getIntExtra("Time",0);



        CountDownTimer count = new CountDownTimer(max*1000,1000) {
            int counter=0;
            TextView timer = (TextView)findViewById(R.id.Timer);
            Button button = (Button)findViewById(R.id.Next);
            RelativeLayout layout = (RelativeLayout)findViewById(R.id.P2);
            Intent intent2 = new Intent(P2.this,P2.class);
            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(String.valueOf(max-millisUntilFinished/1000));

                if((max-millisUntilFinished/1000)<bonus)
                {
                    layout.setBackgroundColor(Color.GREEN);
                }
                else if((max-millisUntilFinished/1000)<(time-time/10))
                {
                    layout.setBackgroundColor(Color.YELLOW);
                }
                else
                {
                    layout.setBackgroundColor(Color.RED);
                }
                button.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        intent2.putExtra("ques",n-1);
                        intent2.putExtra("Max",max);
                        intent2.putExtra("Bonus",bonus);
                        intent2.putExtra("Time",time);
                        startActivity(intent2);
                    }
                });

            }

            @Override
            public void onFinish() {
                timer.setText("Skip this Question");
                button.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        intent2.putExtra("ques",n-1);
                        intent2.putExtra("Max",max);
                        intent2.putExtra("Bonus",bonus);
                        intent2.putExtra("Time",time);
                        startActivity(intent2);
                    }
                });

            }
        };
        if(n>0)
        {
            count.start();
        }
        else{
            TextView timer = (TextView)findViewById(R.id.Timer);
            Button button = (Button)findViewById(R.id.Next);
            final Intent intent3 = new Intent(P2.this,MainActivity.class);
            timer.setText("Well Done");
            button.setOnClickListener(new Button.OnClickListener(){
                public void onClick(View v){
                  startActivity(intent3);
                }
            });
        }

    }
}
