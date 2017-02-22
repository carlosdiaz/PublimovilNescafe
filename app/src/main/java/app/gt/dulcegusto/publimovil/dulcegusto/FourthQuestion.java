package app.gt.dulcegusto.publimovil.dulcegusto;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FourthQuestion extends AppCompatActivity {

    String thirdanswers = "";
    String colorSelected;
    private String hourSelected;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_question);

        rb1 = (RadioButton) findViewById(R.id.foqradioOption1);
        rb2 = (RadioButton) findViewById(R.id.foqradioOption2);
        rb3 = (RadioButton) findViewById(R.id.foqradioOption3);
        rb4 = (RadioButton) findViewById(R.id.foqradioOption4);
        rb5 = (RadioButton) findViewById(R.id.foqradioOption5);
        rb6 = (RadioButton) findViewById(R.id.foqradioOption6);
        rb1.setChecked(true);


        thirdanswers = getIntent().getStringExtra("tq");
        //System.out.println(thirdanswers);
        this.colorSelected = getIntent().getStringExtra("color");
        //System.out.println(this.colorSelected);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("FourthQuestion","Saving information");

                // We get the hour selected, assigned to colorSelected
                saveAnswers();

                saveQuestions(getApplicationContext(), "Answers.txt", thirdanswers + hourSelected + "\n");

                Intent myIntent = new Intent(FourthQuestion.this, ResultsActivity.class);
                myIntent.putExtra("results", getResults());
                //myIntent.putExtra("hour", hourSelected);
                FourthQuestion.this.startActivity(myIntent);

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

        this.hourSelected = answers;
        //System.out.println("***********************");
        //System.out.println("Hour: "  +this.hourSelected);

        return (answers);
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
                //System.out.println(ex.toString());
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
                //System.out.println(ex.toString());
                ex.printStackTrace();
            }

        }
    }

    //This method will retrieve the coffee response choice
    public String getResults() {
        String response = "";

        //System.out.println("Color1: "+this.colorSelected);
        //System.out.println("Hour1: " +hourSelected);

        if (this.colorSelected.equals("Amarillo")) {
            //System.out.println("here1");
            if (hourSelected.equals("En la mañana")) {
                //System.out.println("here2");
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Americano";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Capuccino Ice";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Capuccino";
            }
        }

        if (this.colorSelected.equals("Azul")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Chocolate / Chococino, Moca";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Capuccino";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Capuccino Ice";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Latte";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
        }

        if (this.colorSelected.equals("Azul turquesa")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Capuccino";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Capuccino";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Latte";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Capuccino Ice";
            }
        }

        if (this.colorSelected.equals("Blanco")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Americano";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Americano";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Lungo";
            }
        }

        if (this.colorSelected.equals("Café")) {

            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            } else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Capuccino";
            } else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Americano";
            } else if (hourSelected.equals("En la tarde")) {
                response = "Chocolate / Chococino, Moca";
            } else if (hourSelected.equals("En la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            } else if (hourSelected.equals("Todo el dia")) {
                response = "Americano";
            }
        }

        if (this.colorSelected.equals("Celeste")) {

            if (hourSelected.equals("En la mañana")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Americano";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Capuccino Ice";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Capuccino";
            }

        }

        if (this.colorSelected.equals("Dorado")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Chocolate / Chococino, Moca";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Americano";
            }
        }

        if (this.colorSelected.equals("Gris")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Americano";
            }
        }

        if (this.colorSelected.equals("Morado/Violeta")) {

            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Americano";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Capuccino Ice";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Americano";
            }

        }


        if (this.colorSelected.equals("Naranja")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Latte";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Capuccino Ice";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Americano";
            }
        }

        if (this.colorSelected.equals("Negro")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Americano";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Capuccino Ice";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Americano";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Lungo";
            }

        }


        if (this.colorSelected.equals("Plateado")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Capuccino";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Capuccino Ice";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Te Chai Latte / Marrakesh Style Tea";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Americano";
            }
        }

        if (this.colorSelected.equals("Rojo")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Americano";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Capuccino";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Americano";
            }
        }

        if (this.colorSelected.equals("Rosado")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Capuccino";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Capuccino";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Latte";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Chocolate / Chococino, Moca";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Lungo";
            }

        }

        if (colorSelected.equals("Verde")) {
            if (hourSelected.equals("En la mañana")) {
                response = "Americano";
            }
            else if (hourSelected.equals("En la mañana y en la tarde")) {
                response = "Espresso";
            }
            else if (hourSelected.equals("En la mañana y en la noche")) {
                response = "Latte";
            }
            else if (hourSelected.equals("En la tarde")) {
                response = "Lungo";
            }
            else if (hourSelected.equals("En la noche")) {
                response = "Chocolate / Chococino, Moca";
            }
            else if (hourSelected.equals("Todo el dia")) {
                response = "Americano";
            }
        }
        //System.out.println("Te gusta " + response);

        return response;
    }

    // We disable the back button
    @Override
    public void onBackPressed() {

    }



}
