package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.datos.mvilchis.bancavf.R;

/**
 * Created by Admin on 05/09/2016.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView logo1Img = (ImageView)findViewById(R.id.logo1);
        //set a onclick listener for when the button gets clicked

        logo1Img.setOnClickListener(new View.OnClickListener() {
            //Start new list activity
            public void onClick(View v) {
                //Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
                //startActivity(mainIntent);
                //finish();
            }
    });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
