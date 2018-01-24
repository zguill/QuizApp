package net.androidbootcamp.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    Button button;
    RadioGroup radioGroup1;
    RadioButton radioButton1, radioButton2, radioButton3;

    public static String questions[]={"How many oscars did the movie the Titanic recieve?","Who is the action star in the movie Terminator?", "Who is the director of Resevior Dogs?", "What is Popeye's profession?", "What is the number on the Herbie the love bug car?","What is the name of the dragon in Mulan?", "What year was Ironman released in theaters?","Who plays the role of Thor in the Marvel Universe?","How many Bond actors have there been?","Who is the director of the Guardians of the Galaxy?"};
    String answer[]={"Eleven","Arnold Schwarzenegger","Quentin Tarantino","Seaman","53","Mushu","2008","Chris Hemsworth","Seven","James Gunn"};
    String options[]={"Four","Eleven","Nine","Arnold Schwarzenegger","Robert Redford","Sylvester Stallone","Quentin Tarantino","Woody Allen","Francis Coppola","Spinach Eater","Seaman","Fisherman","23","51","53","Mulan","Fin Fang Foom","Mushu","2008","2007","2006", "Chris Pine","Chris Hemsworth","Chris Pratt","Five","Seven","Eight","James Gunn","Joss Wheldon","Jon Favreau"};

    int flag= 0;
    public static int marks, correct, wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=(TextView)findViewById(R.id.textView1);
        button=(Button)findViewById(R.id.button);
        radioGroup1= (RadioGroup)findViewById(R.id.radioGroup1);
        radioButton1=(RadioButton)findViewById(R.id.radioButton1);
        radioButton2= (RadioButton)findViewById(R.id.radioButton2);
        radioButton3= (RadioButton)findViewById(R.id.radioButton3);

        textView1.setText(questions[flag]);
        radioButton1.setText(options[flag]);
        radioButton2.setText(options[flag+1]);
        radioButton3.setText(options[flag+2]);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedans=(RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId());
                String selectedansText=selectedans.getText().toString();

                if (selectedansText==answer[flag])
                {
                    correct++;
                }
                else
                    {
                    wrong++;
                }
                flag++;
                if (flag<questions.length)
                {
                    textView1.setText(questions[flag]);
                    radioButton1.setText(options[flag*3]);
                    radioButton2.setText(options[flag*3+1]);
                    radioButton3.setText(options[flag*3+2]);
                }
                else
                {
                Intent intent = new Intent(getApplicationContext(),Results.class);
                startActivity(intent);
                }
            }
        });

    }
}
