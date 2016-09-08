package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.datos.mvilchis.bancavf.R;

/**
 * Consultation activity that show the table related with
 * the consultation
 * @author Miguel Alonso Vilchis Domínguez
 */
public class ConsultationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);
        /*Manage each image one by one */
        //************* Declaration of intents *************
        final Intent movement_intent = new Intent(this, MovementActivity.class);
        //************* Movements  *************
        ImageView movement_image_1 = (ImageView)findViewById(R.id.movimientos1);
        movement_image_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movement_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(movement_intent);
            }
        });

        ImageView movement_image_2 = (ImageView)findViewById(R.id.movimientos2);
        movement_image_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movement_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(movement_intent);
            }
        });

        ImageView movement_image_3 = (ImageView)findViewById(R.id.movimientos3);
        movement_image_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movement_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(movement_intent);
            }
        });

        /**************  Set return button ***************/
        ImageView return_to_parent_button = (ImageView)findViewById(R.id.return_to_parent);
        return_to_parent_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("Entro a option item selected");
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
