package app.gt.dulcegusto.publimovil.dulcegusto;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RelativeLayout;
import java.util.Timer;
import java.util.Random;
import java.util.TimerTask;
import android.os.Handler;

/**
 * Created by carlos on 9/02/17.
 */

public class ResultsActivity extends Activity {

    private EditText coffeeEdit;
    private TextView coffeeResults;
    private String results = "";
    int images[] = {R.drawable.dg6, R.drawable.dg1};
    //RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        //String cofee = getIntent().getStringExtra("COFFEE_CHOICE");
        String cofee = getIntent().getStringExtra("results");
        //System.out.println(cofee);


        results = getIntent().getStringExtra("foq");
        //System.out.println(results);

        //relativeLayout = (RelativeLayout) findViewById(R.id.results1);


        coffeeResults = (TextView) findViewById(R.id.textViewResults);
        coffeeResults.setText("Te recomendamos: " + cofee);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ResultsActivity.this, PrincipalActivity2.class);
                ResultsActivity.this.startActivity(myIntent);

            }
        });

        /*
        relativeLayout.setBackgroundResource(images[getRandomNumber()]);
        Timer myTimer;
        myTimer = new Timer();
        myTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                TimerMethod();
            }
        }, 0, 9000);
        */
    }
    /*

    private int getRandomNumber() {
        return new Random().nextInt(2);
    }

    private void TimerMethod()
    {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                //TODO after 9 sec
                relativeLayout.setBackgroundResource(images[getRandomNumber()]);
            }
        }, 9000);
    }
    */





    public void startPrincipal(View view) {
        Intent myIntent = new Intent(ResultsActivity.this, PrincipalActivity2.class);
        ResultsActivity.this.startActivity(myIntent);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle("Confirmacion");

        // set dialog message
        alertDialogBuilder
                .setMessage("¿Desea salir?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //Intent intent = new Intent(ResultsActivity.this, PrincipalActivity2.class);
                        Intent intent = new Intent(ResultsActivity.this, PrincipalActivity2.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("killme", true);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }


}