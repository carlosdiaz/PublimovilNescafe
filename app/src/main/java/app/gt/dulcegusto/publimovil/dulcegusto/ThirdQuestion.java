package app.gt.dulcegusto.publimovil.dulcegusto;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ThirdQuestion extends AppCompatActivity {
    String secondanswers = "";
    private String colorSelected;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        rb1 = (RadioButton) findViewById(R.id.tqradioButton1);
        rb2 = (RadioButton) findViewById(R.id.tqradioButton2);
        rb3 = (RadioButton) findViewById(R.id.tqradioButton3);
        rb4 = (RadioButton) findViewById(R.id.tqradioButton4);
        rb5 = (RadioButton) findViewById(R.id.tqradioButton5);
        rb6 = (RadioButton) findViewById(R.id.tqradioButton6);
        rb7 = (RadioButton) findViewById(R.id.tqradioButton7);
        rb8 = (RadioButton) findViewById(R.id.tqradioButton8);
        rb9 = (RadioButton) findViewById(R.id.tqradioButton9);
        rb10 = (RadioButton) findViewById(R.id.tqradioButton10);
        rb1.setChecked(true);


        secondanswers = getIntent().getStringExtra("sq");
        //System.out.println(secondanswers);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(ThirdQuestion.this, FourthQuestion.class);
                myIntent.putExtra("tq", secondanswers + saveAnswers());
                myIntent.putExtra("color", colorSelected);
                ThirdQuestion.this.startActivity(myIntent);

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
        else if (rb8.isChecked()) {
            answers = rb8.getText().toString();
        }
        else if (rb9.isChecked()) {
            answers = rb9.getText().toString();
        }
        else if (rb10.isChecked()) {
            answers = rb10.getText().toString();
        }
        this.colorSelected = answers;

        return (answers + ",");

    }

    // We disable the back button
    @Override
    public void onBackPressed() {

    }


}
