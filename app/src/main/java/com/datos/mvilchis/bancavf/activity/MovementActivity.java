package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.datos.mvilchis.bancavf.R;
import com.datos.mvilchis.bancavf.utilites.ConstantMessage;

/**
 * Movement activity that show a simple table
 * @author Miguel Alonso Vilchis Domínguez
 */
public class MovementActivity  extends  Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement);
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
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(MovementActivity.this,message_string );
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


