package com.jiit62.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt);
        Intent intent = getIntent();
        timer(intent);
    }
    void timer(Intent intent)
    {
        final int Break = intent.getIntExtra("breaktime",0);
        final String LOG_TAG = BT.class.getSimpleName();
        Log.i(LOG_TAG,String.valueOf(Break));
        final TextView textView = (TextView)findViewById(R.id.timer2);
        final RelativeLayout layout = (RelativeLayout)findViewById(R.id.BT);
        CountDownTimer count = new CountDownTimer(Break*1000,1000)
        {
            int counter=0;

            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(String.valueOf(Break-counter));
                counter++;
                if(Break-counter>10)
                    layout.setBackgroundColor(Color.GREEN);
                else
                    layout.setBackgroundColor(Color.RED);
            }

            @Override
            public void onFinish() {
                Button button = (Button)findViewById(R.id.button3);
                button.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View v){
                        finish();

                    }
                });


            }
        } ;
        count.start();
    }
}
