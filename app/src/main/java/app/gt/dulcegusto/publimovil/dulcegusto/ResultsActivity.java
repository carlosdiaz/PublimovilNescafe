package app.gt.dulcegusto.publimovil.dulcegusto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by carlos on 9/02/17.
 */

public class ResultsActivity extends Activity {

    private EditText coffeeEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_layout);
        String cofee = getIntent().getStringExtra("COFFEE_CHOICE");
        coffeeEdit = (EditText) findViewById(R.id.resultsText1);
        coffeeEdit.setKeyListener(null);

        coffeeEdit.setText("Te recomendamos: " + cofee);

    }


    public void startPrincipal(View view){
        Intent myIntent = new Intent(ResultsActivity.this, PrincipalActivity2.class);
        //myIntent.putExtra("key", value);
        //Open the new questions activity
        ResultsActivity.this.startActivity(myIntent);


    }

}
