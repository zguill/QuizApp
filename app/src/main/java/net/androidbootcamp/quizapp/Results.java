package net.androidbootcamp.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;

public class Results extends AppCompatActivity {

    TextView textView2;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        textView2= (TextView)findViewById(R.id.textView2);
        button2=(Button)findViewById(R.id.button2);

        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("Correct Ans: "+MainActivity.correct);
        stringBuffer.append("Wrong Ans: "+MainActivity.wrong);
        stringBuffer.append("Final Score "+MainActivity.marks);
        textView2.setText("You got "+MainActivity.correct+" out of "+MainActivity.questions.length+" questions correct!!");

        MainActivity.correct=0;
        MainActivity.wrong=0;

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
