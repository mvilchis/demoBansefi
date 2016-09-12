package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.datos.mvilchis.bancavf.R;
import com.datos.mvilchis.bancavf.utilites.ConstantMessage;

import org.w3c.dom.Text;

/**
 * Movement activity that show a simple table
 * @author Miguel Alonso Vilchis Domínguez
 */
public class PaymentCodeActivity  extends  Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        setContentView(R.layout.activity_paycellphone_code);
        TextView ammount_text = (TextView) findViewById(R.id.ammount_text);
        ammount_text.setText(prefs.getString("pay_ammount", ""));

        /*********** Intent list *****************/
        final Intent pay_code_intent = new Intent(this, PaymentQrActivity.class);
        /************ Work wiht table *************/
        TextView change_view = (TextView)findViewById(R.id.change_to_qr);
        change_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pay_code_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pay_code_intent);
            }
        });
        /**************  Set return button ***************/
        ImageView return_to_parent_button = (ImageView)findViewById(R.id.return_to_parent);
        return_to_parent_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Return to main Activity
                Intent main_intent = new Intent(PaymentCodeActivity.this, MainActivity.class);
                startActivity(main_intent);
                finish();
            }
        });
        /************** settings points button **************/
        final ImageView settings = (ImageView)findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentCodeActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });
        final ImageView share_button = (ImageView)findViewById(R.id.share_button);
        share_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentCodeActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}



