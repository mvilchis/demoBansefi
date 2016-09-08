package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
public class PaymentActivity  extends  Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        /*********** Intent list *****************/
        final Intent pay_cellphone_intent = new Intent(this, PaymentCellActivity.class);
        /************ Work wiht table *************/
        final TableRow pay_with_cell = (TableRow) findViewById(R.id.pay_with_cellphone);
        final TextView pay_cell_child = (TextView)findViewById(R.id.pay_cell_child);
        pay_with_cell.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pay_with_cell.setBackgroundResource(R.color.red_background);
                pay_cell_child.setTextColor(Color.WHITE);
                pay_cellphone_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pay_cellphone_intent);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}


