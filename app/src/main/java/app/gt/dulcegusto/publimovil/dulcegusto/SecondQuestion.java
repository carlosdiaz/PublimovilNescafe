package app.gt.dulcegusto.publimovil.dulcegusto;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondQuestion extends AppCompatActivity {

    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    String firstanswers = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        firstanswers = getIntent().getStringExtra("fq");
        //System.out.println(firstanswers);

        rb1 = (RadioButton) findViewById(R.id.sqradioButton);
        rb2 = (RadioButton) findViewById(R.id.sqradioButton2);
        rb3 = (RadioButton) findViewById(R.id.sqradioButton3);
        rb4 = (RadioButton) findViewById(R.id.sqradioButton4);
        rb5 = (RadioButton) findViewById(R.id.sqradioButton5);
        rb6 = (RadioButton) findViewById(R.id.sqradioButton6);
        rb7 = (RadioButton) findViewById(R.id.sqradioButton7);
        rb1.setChecked(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(SecondQuestion.this, ThirdQuestion.class);
                //We pass the second answers answers
                myIntent.putExtra("sq", firstanswers + saveAnswers());
                SecondQuestion.this.startActivity(myIntent);

            }
        });

    }



    private String saveAnswers() {

        String answers = "";

        if (rb1.isChecked()) {
            answers = rb1.getText().toString();
        }
        else if (rb2.isChecked()) {
            answers = rb2.getText().toString();
        }
        else if (rb3.isChecked()) {
            answers = rb3.getText().toString();
        }
        else if (rb4.isChecked()) {
            answers = rb4.getText().toString();
        }
        else if (rb5.isChecked()) {
            answers = rb5.getText().toString();
        }
        else if (rb6.isChecked()) {
            answers = rb6.getText().toString();
        }
        else if (rb7.isChecked()) {
            answers = rb7.getText().toString();
        }

        return (answers + ",");

    }

    // We disable the back button
    @Override
    public void onBackPressed() {

    }


}
