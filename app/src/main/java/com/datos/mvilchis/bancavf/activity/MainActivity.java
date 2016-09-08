package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.datos.mvilchis.bancavf.R;

/**
 * Main activity that show all items in a table
 * @author Miguel Alonso Vilchis Domínguez
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Manage each image one by one */
        //************* Declaration of intents *************
        final Intent consultation_intent = new Intent(this, ConsultationActivity.class);
        final Intent payment_intent = new Intent(this, PaymentActivity.class);
        final Intent collect_intent = new Intent(this, CollectActivity.class);

        //************* Consultation  *************
        final ImageView consultation_image = (ImageView)findViewById(R.id.logo1);
        consultation_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                consultation_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(consultation_intent);
            }
        });
        //************* Payment  *************
        final ImageView payment_image = (ImageView)findViewById(R.id.logo3);
        payment_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                payment_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(payment_intent);
            }
        });
        //************* Collect **************
        final ImageView collect_image = (ImageView)findViewById(R.id.logo4);
        collect_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                collect_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(collect_intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
