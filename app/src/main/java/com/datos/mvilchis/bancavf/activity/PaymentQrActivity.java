package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
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
public class PaymentQrActivity  extends  Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paycellphone_qr);
        /*********** Intent list *****************/
        final Intent pay_code_intent = new Intent(this, PaymentCodeActivity.class);
        /************ Work wiht table *************/
        TextView change_view = (TextView)findViewById(R.id.chage_to_code);
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
                Intent payment_intent = new Intent(PaymentQrActivity.this, PaymentActivity.class);
                startActivity(payment_intent);
                finish();
            }
        });
        /************** settings points button **************/
        final ImageView settings = (ImageView)findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentQrActivity.this,message_string );
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



