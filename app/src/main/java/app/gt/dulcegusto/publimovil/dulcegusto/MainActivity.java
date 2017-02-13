package app.gt.dulcegusto.publimovil.dulcegusto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Created by carlos on 9/02/17.
 */

public class MainActivity extends AppCompatActivity {

    private int counterQuestion = 1;
    private int totalQuestions = 4;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8,
            rb9, rb10, rb11, rb12, rb13, rb14, rb15;
    private TextView question;
    private RadioGroup rd1;
    private String colorSelected;
    private String hourSelected;

    QuestionUtils questions = new QuestionUtils();
    ArrayList<String> answers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.setTitle("Publimovil");
        rd1 = (RadioGroup) findViewById(R.id.radioGroup1);

        rb1 = (RadioButton) findViewById(R.id.radioOption1);
        rb2 = (RadioButton) findViewById(R.id.radioOption2);
        rb3 = (RadioButton) findViewById(R.id.radioOption3);
        rb4 = (RadioButton) findViewById(R.id.radioOption4);
        rb5 = (RadioButton) findViewById(R.id.radioOption5);
        rb6 = (RadioButton) findViewById(R.id.radioOption6);
        rb7 = (RadioButton) findViewById(R.id.radioOption7);

        rb8 = (RadioButton) findViewById(R.id.radioOption8);
        rb9 = (RadioButton) findViewById(R.id.radioOption9);
        rb10 = (RadioButton) findViewById(R.id.radioOption10);
        rb11 = (RadioButton) findViewById(R.id.radioOption11);
        rb12 = (RadioButton) findViewById(R.id.radioOption12);

        rb13 = (RadioButton) findViewById(R.id.radioOption13);
        rb14 = (RadioButton) findViewById(R.id.radioOption14);
        rb15 = (RadioButton) findViewById(R.id.radioOption15);





        question = (TextView) findViewById(R.id.editText1);
        //We disable the option to edit the edit text field
        question.setKeyListener(null);
        this.hourSelected = "";
        this.colorSelected = "";

        disableInitialRB();

    }

    public void loadNewQuestionLayout(View view) {
        //System.out.println("Inside clic");
        System.out.println("loadNewQuestion");
        saveAnwsers();
        loadNewQuestion();

        // All of the questions have been answered, we need to store it in a file
        if (this.counterQuestion == this.totalQuestions+1) {
            System.out.println("Saving the answers");
            saveQuestions(this.getApplicationContext(), "Answers.txt", getAnswersConcatenated());

            getResults();

            //If we have the last question we send the user to the results layout
            Intent myIntent = new Intent(MainActivity.this, ResultsActivity.class);
            myIntent.putExtra("COFFEE_CHOICE", getResults());
            //Open the new questions activity
            MainActivity.this.startActivity(myIntent);

        }

    }

    /*
    * This method will load the next question
    */
    private void loadNewQuestion() {

        this.counterQuestion ++;
        rd1.check(R.id.radioOption1);

        question.setFocusableInTouchMode(true);
        question.setFocusable(true);
        question.requestFocus();

        //rb1.setFocusableInTouchMode(true);
        //rb1.setFocusable(true);
        //rb1.requestFocus();


        //If we still have questions to be displayed
        if (this.counterQuestion <= this.totalQuestions) {
            //Save the anwsers in an array list
            if (counterQuestion == 2) {
                loadQuestion2();
            } else if (counterQuestion == 3) {
                loadQuestion3();
            }
            else if (counterQuestion == 4) {
                loadQuestion4();
            }

        }

    }

    private void saveAnwsers() {

        if (this.counterQuestion == 1) {
            saveAnswers1();

        }
        else if (this.counterQuestion == 2) {
            saveAnswers2();

        }
        else if (this.counterQuestion == 3) {
            saveAnswers3();
        }
        else if (this.counterQuestion == 4) {
            saveAnswers4();
        }


        //System.out.println("Save answers" + answers.toString());

    }

    private void saveAnswers1() {

        if (rb1.isChecked()) {
            answers.add(rb1.getText().toString());
        }
        else if (rb2.isChecked()) {
            answers.add(rb2.getText().toString());
        }
        else if (rb3.isChecked()) {
            answers.add(rb3.getText().toString());
        }

    }

    //These are the aswers of the age
    private void saveAnswers2() {

        if (rb1.isChecked()) {
            answers.add(rb1.getText().toString());
        }
        else if (rb2.isChecked()) {
            answers.add(rb2.getText().toString());
        }
        else if (rb3.isChecked()) {
            answers.add(rb3.getText().toString());
        }
        else if (rb4.isChecked()) {
            answers.add(rb4.getText().toString());
        }
        else if (rb5.isChecked()) {
            answers.add(rb5.getText().toString());
        }
        else if (rb6.isChecked()) {
            answers.add(rb6.getText().toString());
        }
        else if (rb7.isChecked()) {
            answers.add(rb7.getText().toString());
        }
    }

    //These are the colors answers
    private void saveAnswers3() {

        if (rb1.isChecked()) {
            answers.add(rb1.getText().toString());
        }
        else if (rb2.isChecked()) {
            answers.add(rb2.getText().toString());
        }
        else if (rb3.isChecked()) {
            answers.add(rb3.getText().toString());
        }
        else if (rb4.isChecked()) {
            answers.add(rb4.getText().toString());
        }
        else if (rb5.isChecked()) {
            answers.add(rb5.getText().toString());
        }
        else if (rb6.isChecked()) {
            answers.add(rb6.getText().toString());
        }
        else if (rb7.isChecked()) {
            answers.add(rb7.getText().toString());
        }
        else if (rb8.isChecked()) {
            answers.add(rb8.getText().toString());
        }
        else if (rb9.isChecked()) {
            answers.add(rb9.getText().toString());
        }
        else if (rb10.isChecked()) {
            answers.add(rb10.getText().toString());
        }
        else if (rb11.isChecked()) {
            answers.add(rb11.getText().toString());
        }
        else if (rb12.isChecked()) {
            answers.add(rb12.getText().toString());
        }
        else if (rb13.isChecked()) {
            answers.add(rb13.getText().toString());
        }
        else if (rb14.isChecked()) {
            answers.add(rb14.getText().toString());
        }
        else if (rb15.isChecked()) {
            answers.add(rb15.getText().toString());
        }

        System.out.println(answers.get(2));
        // We save the color choice
        this.colorSelected = answers.get(2);

    }


    private void saveAnswers4() {

        if (rb1.isChecked()) {
            answers.add(rb1.getText().toString());
        }
        else if (rb2.isChecked()) {
            answers.add(rb2.getText().toString());
        }
        else if (rb3.isChecked()) {
            answers.add(rb3.getText().toString());
        }
        else if (rb4.isChecked()) {
            answers.add(rb4.getText().toString());
        }
        else if (rb5.isChecked()) {
            answers.add(rb5.getText().toString());
        }
        else if (rb6.isChecked()) {
            answers.add(rb6.getText().toString());
        }

        System.out.println(answers.get(3));
        //We save the hour selected choice
        this.hourSelected = answers.get(3);

    }


    /*
    This function will retrieve the answers made by the user in a String text comma delimited
     */
    public String getAnswersConcatenated() {

        int i;
        String outputAnswers = "";
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm a");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);

        System.out.println("getAnswersConcatenated");

        for (i=0; i<answers.size()-1; i++)
        {
            outputAnswers =  outputAnswers + answers.get(i) + "," ;
        }
        if (i == answers.size()-1) {
            outputAnswers = strDate + "," + outputAnswers  + answers.get(i) + "\n";
        }
        System.out.println(outputAnswers);

        return outputAnswers;
    }

    @Override
    public void onBackPressed() {
    }


    public void disableInitialRB()
    {
        rb3.setVisibility(View.GONE);
        rb4.setVisibility(View.GONE);
        rb5.setVisibility(View.GONE);
        rb6.setVisibility(View.GONE);
        rb7.setVisibility(View.GONE);
        rb8.setVisibility(View.GONE);
        rb9.setVisibility(View.GONE);
        rb10.setVisibility(View.GONE);
        rb11.setVisibility(View.GONE);
        rb12.setVisibility(View.GONE);
        rb13.setVisibility(View.GONE);
        rb14.setVisibility(View.GONE);
        rb15.setVisibility(View.GONE);

    }

    public void saveQuestions(Context context, String sFileName, String sBody) {
        File root = new File(Environment.getExternalStorageDirectory(), "Answers");
        if (!root.exists()) {
            root.mkdirs();
            try {
                File gpxfile = new File(root, sFileName);
                FileWriter writer = new FileWriter(gpxfile);
                writer.append(sBody);
                writer.flush();
                writer.close();
                Toast.makeText(context, "Respuestas guardadas", Toast.LENGTH_SHORT).show();
            } catch (IOException ex) {
                System.out.println(ex.toString());
                ex.printStackTrace();
            }
        }
        else{
            try{
                File gpxfile = new File(root, sFileName);
                FileWriter writer = new FileWriter(gpxfile , true);
                writer.append(sBody);
                writer.flush();
                writer.close();
                Toast.makeText(context, "Respuestas guardadas", Toast.LENGTH_SHORT).show();
            }
            catch (IOException ex) {
                System.out.println(ex.toString());
                ex.printStackTrace();
            }

        }
    }

    //Age
    public void loadQuestion2() {
        // The ideal scenario would be to have only one funtion that retrieves the information
        question.setText(questions.questions.get(1));
        rb3.setVisibility(View.VISIBLE);
        rb4.setVisibility(View.VISIBLE);
        rb5.setVisibility(View.VISIBLE);
        rb6.setVisibility(View.VISIBLE);
        rb7.setVisibility(View.VISIBLE);
        rb1.setText(questions.answers2.get(0));
        rb2.setText(questions.answers2.get(1));
        rb3.setText(questions.answers2.get(2));
        rb4.setText(questions.answers2.get(3));
        rb5.setText(questions.answers2.get(4));
        rb6.setText(questions.answers2.get(5));
        rb7.setText(questions.answers2.get(6));

    }

    //Colors
    public void loadQuestion3() {
        // The ideal scenario would be to have only one funtion that retrieves the information
        question.setText(questions.questions.get(2));

        rb8.setVisibility(View.VISIBLE);
        rb9.setVisibility(View.VISIBLE);
        rb10.setVisibility(View.VISIBLE);
        /*
        rb11.setVisibility(View.VISIBLE);
        rb12.setVisibility(View.VISIBLE);
        rb13.setVisibility(View.VISIBLE);
        rb14.setVisibility(View.VISIBLE);
        rb15.setVisibility(View.VISIBLE);
        */


        rb1.setText(questions.answers3.get(0));
        rb2.setText(questions.answers3.get(1));
        rb3.setText(questions.answers3.get(2));
        rb4.setText(questions.answers3.get(3));
        rb5.setText(questions.answers3.get(4));
        rb6.setText(questions.answers3.get(5));
        rb7.setText(questions.answers3.get(6));
        rb8.setText(questions.answers3.get(7));
        rb9.setText(questions.answers3.get(8));
        rb10.setText(questions.answers3.get(9));
        /*
        rb11.setText(questions.answers3.get(10));
        rb12.setText(questions.answers3.get(11));

        rb13.setText(questions.answers3.get(12));
        rb14.setText(questions.answers3.get(13));
        rb15.setText(questions.answers3.get(14));
        */



    }

    //Time
    public void loadQuestion4() {
        // The ideal scenario would be to have only one funtion that retrieves the information
        question.setText(questions.questions.get(3));
        rb7.setVisibility(View.GONE);
        rb8.setVisibility(View.GONE);
        rb9.setVisibility(View.GONE);
        rb10.setVisibility(View.GONE);
        rb11.setVisibility(View.GONE);
        rb12.setVisibility(View.GONE);
        rb13.setVisibility(View.GONE);
        rb14.setVisibility(View.GONE);
        rb15.setVisibility(View.GONE);


        rb1.setText(questions.answers4.get(0));
        rb2.setText(questions.answers4.get(1));
        rb3.setText(questions.answers4.get(2));
        rb4.setText(questions.answers4.get(3));
        rb5.setText(questions.answers4.get(4));
        rb6.setText(questions.answers4.get(5));


    }

    //This method will retrieve the coffee response choice
    public String getResults() {
        String response = "";

        if (this.colorSelected == "Amarillo") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Americano";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Capuccino Ice";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Capuccino";
            }
        }

        if (this.colorSelected == "Azul") {

            if (this.hourSelected=="En la mañana") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Chocolate / Chococino, Moca";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Capuccino";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Capuccino Ice";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Latte";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
        }

        if (this.colorSelected == "Azul turquesa") {

            if (this.hourSelected=="En la mañana") {
                response = "Capuccino";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Capuccino";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Latte";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Capuccino Ice";
            }
        }

        if (this.colorSelected == "Blanco") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Americano";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Americano";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Lungo";
            }
        }

        if (this.colorSelected == "Café") {

            if (this.hourSelected == "En la mañana") {
                response = "Espresso";
            } else if (this.hourSelected == "En la mañana y en la tarde") {
                response = "Capuccino";
            } else if (this.hourSelected == "En la mañana y en la noche") {
                response = "Americano";
            } else if (this.hourSelected == "En la tarde") {
                response = "Chocolate / Chococino, Moca";
            } else if (this.hourSelected == "En la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            } else if (this.hourSelected == "Todo el dia") {
                response = "Americano";
            }
        }

        if (this.colorSelected == "Celeste") {

            if (this.hourSelected=="En la mañana") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Americano";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Capuccino Ice";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Capuccino";
            }

        }

        if (this.colorSelected == "Dorado") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Chocolate / Chococino, Moca";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Americano";
            }

        }

        if (this.colorSelected == "Gris") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Americano";
            }

        }

        if (this.colorSelected == "Morado/Violeta") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Americano";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Capuccino Ice";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Americano";
            }

        }


        if (this.colorSelected == "Naranja") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Latte";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Capuccino Ice";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Americano";
            }

        }

        if (this.colorSelected == "Negro") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Americano";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Capuccino Ice";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Americano";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Lungo";
            }

        }


        if (this.colorSelected == "Plateado") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Capuccino";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Capuccino Ice";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Americano";
            }

        }

        if (this.colorSelected == "Rojo") {

            if (this.hourSelected=="En la mañana") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Americano";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Capuccino";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Americano";
            }

        }

        if (this.colorSelected == "Rosado") {

            if (this.hourSelected=="En la mañana") {
                response = "Capuccino";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Capuccino";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Latte";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Chocolate / Chococino, Moca";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Lungo";
            }

        }

        if (this.colorSelected == "Verde") {

            if (this.hourSelected=="En la mañana") {
                response = "Americano";
            }
            else if (this.hourSelected=="En la mañana y en la tarde") {
                response = "Espresso";
            }
            else if (this.hourSelected=="En la mañana y en la noche") {
                response = "Latte";
            }
            else if (this.hourSelected=="En la tarde") {
                response = "Lungo";
            }
            else if (this.hourSelected=="En la noche") {
                response = "Chocolate / Chococino, Moca";
            }
            else if (this.hourSelected=="Todo el dia") {
                response = "Americano";
            }
        }

        return response;
    }

}
