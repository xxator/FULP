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
         final int runT =intent.getIntExtra("runtime",0);

         final RelativeLayout layout = (RelativeLayout)findViewById(R.id.runT);
         CountDownTimer count= new  CountDownTimer(runT*1000, 1000){
                    int timerc = 0;
             int ri= 100;
             int gi = 0;
             int rf = 0;
             int gf = 250;
             int bi = 0;
             int bf = 0;
             final int changingSpeed = runT/(30);
                    public void onTick(long millisUntilFinished){
                    textView.setText(String.valueOf(runT-timerc));
                        timerc++;
                        double dr = (rf - ri);
                        double dg = (gf - gi);
                        double db = (bf - bi);


                        // step 3
                        double norm = Math.sqrt(dr*dr+dg*dg+db*db);
                        dr /= norm;
                        dg /= norm;
                        db /= norm;
                        // step 4
                        dr *= Math.min(changingSpeed, norm);
                        dg *= Math.min(changingSpeed, norm);
                        db *= Math.min(changingSpeed, norm);

                        // step 5
                        ri += dr;
                        gi += dg;
                        bi += db;


                        layout.setBackgroundColor(Color.rgb(ri,gi,100-ri));

                        /*if(timerc<=(runT/3))
                        {
                            layout.setBackgroundColor(Color.GREEN);
                        }
                        else if(timerc>(runT/3)&&timerc<2*(runT/3))
                        {
                            layout.setBackgroundColor(Color.YELLOW);
                        }
                        else
                        {
                            layout.setBackgroundColor(Color.RED);
                        }*/

            }
                public  void onFinish()
                {
                    textView.setText("FINISH!!");
                    Button button = (Button)findViewById(R.id.start);
                    //final Intent intent2=new Intent(RT.this,F1.class);
                    button.setOnClickListener(new Button.OnClickListener(){
                        public void onClick(View v){
                            //final int Break =getIntent().getIntExtra("breaktime",0)*60*1000;
                            //intent2.putExtra("breaktime",Break);
                            finish();
                        }

                    });
                }
            };
            count.start();

    }

}




