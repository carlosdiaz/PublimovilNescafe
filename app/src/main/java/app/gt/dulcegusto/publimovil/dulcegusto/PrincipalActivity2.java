package app.gt.dulcegusto.publimovil.dulcegusto;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.DialogInterface;
import 	android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.app.Activity;
import android.widget.ImageSwitcher;
import android.widget.ViewSwitcher.ViewFactory;
import android.app.ActionBar.LayoutParams;
import android.view.animation.AnimationUtils;



public class PrincipalActivity2 extends Activity {

    AnimationDrawable startingAnimation;
    RelativeLayout rl;
    private ImageSwitcher imageSwitcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal1);
        if( getIntent().getBooleanExtra("killme", false)){
            finish();
        }

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);


        //startingImage.setBackground(R.drawable.animationmain);
        //rl = (RelativeLayout)findViewById(R.id.mainrelative);
        //startingAnimation = (AnimationDrawable) rl.getBackground();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(PrincipalActivity2.this, FirstQuestion.class);
                PrincipalActivity2.this.startActivity(myIntent);


            }
        });
        enableLoadingImage();


    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this   );

        // set title
        alertDialogBuilder.setTitle("Confirmacion");
        alertDialogBuilder
                .setMessage("¿Desea salir?")
                .setCancelable(false)
                .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        PrincipalActivity2.this.finish();

                        Intent intent = new Intent(PrincipalActivity2.this, PrincipalActivity2.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("killme", true);
                        startActivity(intent);
                        finish();


                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void enableLoadingImage() {

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);

        ImageView image = (ImageView) findViewById(R.id.imageView1);
        //image.setVisibility(View.GONE);

        imageSwitcher.setFactory(new ViewFactory() {

            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                return myView;
            }

        });

        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        imageSwitcher.postDelayed(new Runnable() {
            int i = -1;

            public void run() {

                i++;

                switch (i) {
                    case 0:
                        imageSwitcher.setImageResource(R.drawable.dg1);
                        break;
                    case 1:
                        imageSwitcher.setImageResource(R.drawable.dg11);
                        i = -1;
                        break;
                }

                imageSwitcher.postDelayed(this, 1000);
            }
        }, 1000);

    }


}
