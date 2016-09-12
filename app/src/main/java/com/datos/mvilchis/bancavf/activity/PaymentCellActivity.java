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
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
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
public class PaymentCellActivity  extends  Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paycellphone);
        /*********** Intent list *****************/
        final Intent pay_qr_intent = new Intent(this, PaymentQrActivity.class);

        /************ Work wiht table *************/
        ImageButton continue_button = (ImageButton)findViewById(R.id.next_button);
        final EditText ammount_pay = (EditText) findViewById(R.id.ammount_pay);
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        continue_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String ammount = ammount_pay.getText().toString();
                if (TextUtils.isEmpty(ammount)) {

                    ammount_pay.setError(getString(R.string.error_field_required));
                    View focusView = null;
                    focusView = ammount_pay;
                    focusView.requestFocus();

                }else if(! isNumeric(ammount)) {
                    ammount_pay.setError(getString(R.string.error_not_number));
                    View focusView = null;
                    focusView = ammount_pay;
                    focusView.requestFocus();
                }
                else {
                    prefs.edit().putString("pay_ammount", ammount).commit();
                    pay_qr_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pay_qr_intent); }

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
        /************** settings points button **************/
        final ImageView settings = (ImageView)findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message_string = ConstantMessage.NOT_READY;
                AlertDialog.Builder message_builder = ConstantMessage.createAlertMessage(PaymentCellActivity.this,message_string );
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
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}


