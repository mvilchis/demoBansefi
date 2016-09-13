package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;

import com.datos.mvilchis.bancavf.R;
import com.datos.mvilchis.bancavf.utilites.ConstantMessage;

/**
 * Main activity that show all items in a table
 * @author Miguel Alonso Vilchis Domínguez
 */
public class MainActivity extends Activity {
    private ImageView consultation_image;
    private ImageView payment_image;
    private ImageView collect_image;


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
        consultation_image = (ImageView)findViewById(R.id.logo1);
        consultation_image.setBackgroundResource(R.color.app_background);
        consultation_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                consultation_image.setBackgroundResource(R.color.red_background);
                consultation_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(consultation_intent);
            }
        });
        //************* Payment  *************
        payment_image = (ImageView)findViewById(R.id.logo3);
        payment_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                payment_image.setBackgroundResource(R.color.red_background);
                payment_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(payment_intent);
            }
        });
        //************* Collect **************
        collect_image  = (ImageView)findViewById(R.id.logo4);
        collect_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                collect_image.setBackgroundResource(R.color.red_background);
                collect_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(collect_intent);
            }
        });
        /************ Message to not ready functions ***************/
        //          Credit
        final ImageView credit_image = (ImageView)findViewById(R.id.logo2);
        credit_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                credit_image.setBackgroundResource(R.color.red_background);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(MainActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                credit_image.setBackgroundResource(R.color.app_background);
                                dialog.cancel();

                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });
        //      Save
        final ImageView save_image = (ImageView)findViewById(R.id.logo6);
        save_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                save_image.setBackgroundResource(R.color.red_background);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(MainActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                save_image.setBackgroundResource(R.color.app_background);
                                dialog.cancel();

                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });
        //      Token
        final ImageView token_image = (ImageView)findViewById(R.id.logo8);
        token_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                token_image.setBackgroundResource(R.color.red_background);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(MainActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                token_image.setBackgroundResource(R.color.app_background);
                                dialog.cancel();

                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });
        //      help
        final ImageView help_image = (ImageView)findViewById(R.id.logo9);
        help_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                help_image.setBackgroundResource(R.color.red_background);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(MainActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                help_image.setBackgroundResource(R.color.app_background);
                                dialog.cancel();

                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });
        //      Messages
        final ImageView messages_image = (ImageView)findViewById(R.id.logo7);
        messages_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                messages_image.setBackgroundResource(R.color.red_background);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(MainActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                messages_image.setBackgroundResource(R.color.app_background);
                                dialog.cancel();

                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        /** Restore all background of the images **/
        consultation_image.setBackgroundResource(R.color.app_background);
        payment_image.setBackgroundResource(R.color.app_background);
        collect_image.setBackgroundResource(R.color.app_background);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
