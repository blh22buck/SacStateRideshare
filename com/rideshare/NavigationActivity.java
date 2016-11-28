package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;

    private Button buttonProfile;
    private Button buttonNewSearch;
    private Button buttonRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        textView = (TextView) findViewById(R.id.textViewUserName);
        Intent intent = getIntent();
        String username = intent.getStringExtra(LoginActivity.USER_NAME);
        textView.setText("Welcome User " + username);

        buttonProfile = (Button) findViewById(R.id.buttonProfile);
        buttonProfile.setOnClickListener(this);

        buttonNewSearch = (Button) findViewById(R.id.button_new_search);
        buttonNewSearch.setOnClickListener(this);

        buttonRating = (Button) findViewById(R.id.buttonRating);
        buttonRating.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonNewSearch){
            startActivity(new Intent(this, NewSearchActivity.class));
        }
        if(v == buttonProfile ) {
            startActivity(new Intent(this, ProfileActivity.class));
        }
        if(v == buttonRating ) {
            startActivity(new Intent(this, RatingActivity.class));
        }
    }
}
