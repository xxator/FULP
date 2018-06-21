package com.jiit62.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class P extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p);


    }
    public void func(View v)
    {
        Intent intent = new Intent(P.this,P2.class );
        EditText ques = (EditText)findViewById(R.id.ques);
        EditText Max = (EditText)findViewById(R.id.Max);
        EditText Bonus = (EditText)findViewById(R.id.Bonus);
        EditText Time = (EditText)findViewById(R.id.time);
        int questions = Integer.parseInt(String.valueOf(ques.getText()));
        int max = Integer.parseInt(String.valueOf(Max.getText()));
        int bonus = Integer.parseInt(String.valueOf(Bonus.getText()));
        int time = Integer.parseInt(String.valueOf(Time.getText()));
        intent.putExtra("ques",questions);
        intent.putExtra("Max",max);
        intent.putExtra("Bonus",bonus);
        intent.putExtra("Time",time);
        startActivity(intent);
    }


}
