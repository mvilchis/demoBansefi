package com.datos.mvilchis.bancavf.utilites;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Admin on 09/09/2016.
 */
public class ConstantMessage {
    public static final String NOT_READY = "Funcionalidad no desarrollada";
    public static final String TEXT_COLOR = "#939393";
    public static AlertDialog.Builder createAlertMessage(Context context, String message) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(message);
        builder1.setCancelable(false);
        return builder1;

    }
}
