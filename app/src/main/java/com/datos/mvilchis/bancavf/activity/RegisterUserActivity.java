package com.datos.mvilchis.bancavf.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.datos.mvilchis.bancavf.R;

/**
 * Created by Admin on 06/09/2016.
 */
public class RegisterUserActivity extends Activity {
        private UserLoginTask mAuthTask = null;
        private View mProgressView;
        private View mLoginFormView;
        private EditText idUser;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_register_user);
                idUser = (EditText) findViewById(R.id.user_id);
                ImageButton mSignInButton = (ImageButton) findViewById(R.id.continue_button);
                mSignInButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                showProgress(true);
                                //HERE WE TRY TO CONNECT TO THE SERVER TO KNOW IF THE USER IS REGISTER
                                mAuthTask = new UserLoginTask(idUser.getText().toString());
                                mAuthTask.execute((Void) null);
                                Intent loginIntent = new Intent(RegisterUserActivity.this, ActivationActivity.class);
                                startActivity(loginIntent);
                                finish();
                        }
                });
                mLoginFormView = findViewById(R.id.login_table);
                mProgressView = findViewById(R.id.table_progress);

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

                //getMenuInflater().inflate(R.menu.main, menu);
                return true;
        }
        /**
         * Shows the progress UI and hides the login form.
         */
        @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
        private void showProgress(final boolean show) {
                // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
                // for very easy animations. If available, use these APIs to fade-in
                // the progress spinner.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

                        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                        mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                                }
                        });

                        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                        mProgressView.animate().setDuration(shortAnimTime).alpha(
                                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                                }
                        });
                } else {
                        // The ViewPropertyAnimator APIs are not available, so simply show
                        // and hide the relevant UI components.
                        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
        }
        /**
         * Represents an asynchronous login/registration task used to authenticate
         * the user.
         */
        public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

                private final String mPassword;

                UserLoginTask( String password) {
                        mPassword = password;
                }

                @Override
                protected Boolean doInBackground(Void... params) {
                        // TODO: attempt authentication against a network service.

                        try {
                                // Simulate network access.
                                Thread.sleep(2000);
                        } catch (InterruptedException e) {
                                return false;
                        }
                        return true;
                }

                @Override
                protected void onPostExecute(final Boolean success) {
                        mAuthTask = null;
                        showProgress(false);


                }
                @Override
                protected void onCancelled() {
                        mAuthTask = null;
                        showProgress(false);
                }
        }

}
