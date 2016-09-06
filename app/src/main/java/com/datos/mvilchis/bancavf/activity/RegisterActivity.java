package com.datos.mvilchis.bancavf.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.datos.mvilchis.bancavf.R;

/**
 * A Register View
 */
public class RegisterActivity extends AppCompatActivity  {

    /**
     * A dummy authentication store containing known user names and passwords.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private EditText mPasswordViewFirst;
    private EditText mPasswordViewSecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Set up the login form.
        mPasswordViewFirst = (EditText) findViewById(R.id.first_password);
        mPasswordViewSecond = (EditText) findViewById(R.id.second_password);
        mPasswordViewSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String first_password = mPasswordViewFirst.getText().toString();
                String second_password = mPasswordViewSecond.getText().toString();
                if ( second_password.equals(first_password)) {
                    ImageView image_check = (ImageView) findViewById(R.id.checkView);
                    image_check.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mPasswordViewSecond.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        ImageButton mSignInButton = (ImageButton) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });


    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {


        // Reset errors.
        mPasswordViewFirst.setError(null);
        mPasswordViewSecond.setError(null);

        // Store values at the time of the login attempt.
        String first_password = mPasswordViewFirst.getText().toString();
        String second_password = mPasswordViewSecond.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid first password,
        if (TextUtils.isEmpty(first_password)) {
            mPasswordViewFirst.setError(getString(R.string.error_field_required));
            focusView = mPasswordViewFirst;
            cancel = true;
        }else if (!isPasswordValid(first_password)) {
            mPasswordViewFirst.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordViewFirst;
            cancel = true;
        }

        //Check  for a valid second password
        if (TextUtils.isEmpty(second_password)) {
            mPasswordViewSecond.setError(getString(R.string.error_field_required));
            focusView = mPasswordViewSecond;
            cancel = true;
        }else if (! second_password.equals(first_password)) {
            mPasswordViewSecond.setError(getString(R.string.error_not_match));
            focusView = mPasswordViewSecond;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            startActivity(new Intent(RegisterActivity.this, RegisterUserActivity.class));
            finish();
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


}

