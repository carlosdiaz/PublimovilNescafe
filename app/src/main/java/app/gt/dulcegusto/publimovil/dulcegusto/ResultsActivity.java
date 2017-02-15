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

/**
 * Created by carlos on 9/02/17.
 */

public class ResultsActivity extends Activity {

    private EditText coffeeEdit;
    private TextView coffeeResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        String cofee = getIntent().getStringExtra("COFFEE_CHOICE");

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


    }


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