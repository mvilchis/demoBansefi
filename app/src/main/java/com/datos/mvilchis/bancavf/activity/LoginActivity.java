package com.datos.mvilchis.bancavf.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.datos.mvilchis.bancavf.R;

/**
 * Created by Admin on 06/09/2016.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton mSignInButton = (ImageButton) findViewById(R.id.sign_in_button);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
