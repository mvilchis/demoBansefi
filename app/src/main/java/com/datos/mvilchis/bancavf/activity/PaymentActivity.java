package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.datos.mvilchis.bancavf.utilites.ConstantMessage;

import org.w3c.dom.Text;

/**
 * Movement activity that show a simple table
 * @author Miguel Alonso Vilchis Domínguez
 */
public class PaymentActivity  extends  Activity {
    private TableRow pay_with_cell;
    private TextView pay_cell_child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        /*********** Intent list *****************/
        final Intent pay_cellphone_intent = new Intent(this, PaymentCellActivity.class);
        /************ Work wiht table *************/
        pay_with_cell = (TableRow) findViewById(R.id.pay_with_cellphone);
        pay_cell_child = (TextView)findViewById(R.id.pay_cell_child);
        pay_with_cell.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pay_with_cell.setBackgroundResource(R.color.red_background);
                pay_cell_child.setTextColor(Color.WHITE);
                pay_cellphone_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pay_cellphone_intent);

            }
        });
        /************ Message to not ready functions ***************/
        final TableRow pay_credit = (TableRow) findViewById(R.id.pay_credit);
        final TextView child_credit = (TextView)findViewById(R.id.child_credit);
        pay_credit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pay_credit.setBackgroundResource(R.color.red_background);
                child_credit.setTextColor(Color.WHITE);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                pay_credit.setBackgroundResource(R.color.app_background);
                                child_credit.setTextColor(Color.parseColor(ConstantMessage.TEXT_COLOR));
                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();

            }
        });
        final TableRow pay_movement = (TableRow) findViewById(R.id.pay_movement);
        final TextView child_movement = (TextView)findViewById(R.id.child_movement);
        pay_movement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pay_movement.setBackgroundResource(R.color.red_background);
                child_movement.setTextColor(Color.WHITE);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                pay_movement.setBackgroundResource(R.color.app_background);
                                child_movement.setTextColor(Color.parseColor(ConstantMessage.TEXT_COLOR));
                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();

            }
        });
        final TableRow pay_account = (TableRow) findViewById(R.id.pay_account);
        final TextView child_account = (TextView)findViewById(R.id.child_account);
        pay_account.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pay_account.setBackgroundResource(R.color.red_background);
                child_account.setTextColor(Color.WHITE);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                pay_account.setBackgroundResource(R.color.app_background);
                                child_account.setTextColor(Color.parseColor(ConstantMessage.TEXT_COLOR));
                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });
        final TableRow pay_bank = (TableRow) findViewById(R.id.pay_bank);
        final TextView child_bank = (TextView)findViewById(R.id.child_bank);

        pay_bank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pay_bank.setBackgroundResource(R.color.red_background);
                child_bank.setTextColor(Color.WHITE);
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentActivity.this,message_string );
                message_builder.setPositiveButton(
                        "Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                pay_bank.setBackgroundResource(R.color.app_background);
                                child_bank.setTextColor(Color.parseColor(ConstantMessage.TEXT_COLOR));
                            }});
                AlertDialog message_alert = message_builder.create();
                message_alert.show();
            }
        });
        /**************  Set return button ***************/
        ImageView return_to_parent_button = (ImageView)findViewById(R.id.return_to_parent);
        return_to_parent_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        /************** settings points button **************/
        final ImageView settings = (ImageView)findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentActivity.this,message_string );
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
    protected void onResume() {
        super.onResume();
        /** Restore all background of the images **/
        pay_with_cell.setBackgroundResource(R.color.app_background);
        pay_cell_child.setTextColor(Color.parseColor(ConstantMessage.TEXT_COLOR));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}


