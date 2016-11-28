package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;

    private Button buttonMessenger;
    private Button buttonRating;
    private Button buttonEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = (TextView) findViewById(R.id.textView_UN_View);
        Intent intent = getIntent();
        String username = intent.getStringExtra(LoginActivity.USER_NAME);
        textView.setText("Welcome User " + username);

        buttonMessenger = (Button) findViewById(R.id.button_Messenger);
        buttonMessenger.setOnClickListener(this);

        buttonRating = (Button) findViewById(R.id.button_Rating);
        buttonRating.setOnClickListener(this);

        buttonEditProfile = (Button) findViewById(R.id.button_edit);
        buttonEditProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonMessenger) {
            startActivity(new Intent(this, MessageLoginActivity.class));
        }
        if (v == buttonRating) {
            startActivity(new Intent(this, RatingActivity.class));
        }
        if (v == buttonEditProfile) {
            startActivity(new Intent(this, EditProfileActivity.class));
        }
    }
}
