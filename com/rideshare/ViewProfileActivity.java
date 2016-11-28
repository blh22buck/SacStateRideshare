package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textUser;

    private Button buttonRate;
    private Button buttonRating;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        Intent intent = getIntent();

        String username = intent.getStringExtra(LoginActivity.USER_NAME);

        textUser.setText(username);

        /*buttonSearchLanding = (Button) findViewById(R.id.buttonSearchLanding);
        buttonSearchLanding.setOnClickListener(this);*/

        buttonRate = (Button) findViewById(R.id.button_rate);
        buttonRate.setOnClickListener(this);

        buttonRating = (Button) findViewById(R.id.buttonRating);
        buttonRating.setOnClickListener(this);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == buttonRate){
            startActivity(new Intent(this, RatingActivity.class));
        }
        if(v == buttonRating) {
            startActivity(new Intent(this, ViewRatingActivity.class));
        }
        if(v == buttonBack ) {
            finish();
        }
    }
}
