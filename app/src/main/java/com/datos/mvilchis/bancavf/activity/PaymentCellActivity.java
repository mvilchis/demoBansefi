package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
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

import org.w3c.dom.Text;

/**
 * Movement activity that show a simple table
 * @author Miguel Alonso Vilchis Domínguez
 */
public class PaymentCellActivity  extends  Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paycellphone);
        /*********** Intent list *****************/
        final Intent pay_qr_intent = new Intent(this, PaymentQrActivity.class);
        /************ Work wiht table *************/
        ImageButton continue_button = (ImageButton)findViewById(R.id.next_button);
        continue_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pay_qr_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pay_qr_intent);
            }
        });
        /**************  Set return button ***************/
        ImageView return_to_parent_button = (ImageView)findViewById(R.id.return_to_parent);
        return_to_parent_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent main_intent = new Intent(PaymentCellActivity.this, PaymentActivity.class);
                startActivity(main_intent);finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}


