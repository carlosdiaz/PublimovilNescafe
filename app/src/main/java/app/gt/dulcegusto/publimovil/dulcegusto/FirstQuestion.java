package app.gt.dulcegusto.publimovil.dulcegusto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FirstQuestion extends AppCompatActivity {

    private RadioButton rb1, rb2;
    private String colorSelected;
    private String hourSelected;
    ArrayList<String> answers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        rb1 = (RadioButton) findViewById(R.id.fqradioOption1);
        rb2 = (RadioButton) findViewById(R.id.fqradioButton2);
        rb1.setChecked(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(FirstQuestion.this, SecondQuestion.class);
                //We pass the first answers
                myIntent.putExtra("fq", saveAnswers());
                FirstQuestion.this.startActivity(myIntent);

            }
        });


    }

    // We disable the back button
    @Override
    public void onBackPressed() {

    }


    private String saveAnswers() {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        String answers = "";

        if (rb1.isChecked()) {
            answers = rb1.getText().toString();
        }
        else if (rb2.isChecked()) {
            answers = rb2.getText().toString();
        }
        return (strDate + "," + answers + ",");
    }


}
