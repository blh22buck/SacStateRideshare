package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MessageLoginActivity extends AppCompatActivity {
    private TextView textView;
    private String username;
    private String password;
    private Intent intent;
    private Intent userNameIntent;
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = new Intent(getApplicationContext(), ListUsersActivity.class);
        serviceIntent = new Intent(getApplicationContext(), MessageService.class);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "9LiuD72xapKDZ0aLkjql7I3EGGG61gudadfgK9Ua", "vBJ6GVdPMPA87AGg7X3hZb4pGG01OPJnMJWssApf");
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            startActivity(intent);
            startService(serviceIntent);
        }

        /*textView = (TextView) findViewById(R.id.textViewUserName);
        userNameIntent = getIntent();*/
        username = "foo";//userNameIntent.getStringExtra(LoginActivity.USER_NAME);
        password = "password";

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            public void done(ParseUser user, com.parse.ParseException e) {
                if (user != null) {
                    startActivity(intent);
                    startService(serviceIntent);
                } else {
                    user = new ParseUser();
                    user.setUsername(username);
                    user.setPassword(password);

                    user.signUpInBackground(new SignUpCallback() {
                        public void done(com.parse.ParseException e) {
                            if (e == null) {
                                startActivity(intent);
                                startService(serviceIntent);
                            }
                        }
                    });

                }
            }
        });
    }

    @Override
    public void onDestroy() {
        stopService(new Intent(this, MessageService.class));
        super.onDestroy();
    }
}
