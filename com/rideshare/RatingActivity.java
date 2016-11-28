package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class RatingActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editComment;

    private RatingBar rateClean;
    private RatingBar rateTime;

    private Button buttonBack;

    private String comment;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        editComment= (EditText) findViewById(R.id.ratingComment);

        rateClean = (RatingBar) findViewById(R.id.cleanRating);
        rateTime = (RatingBar) findViewById(R.id.timeRating);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v == buttonBack){
            finish();
        }
    }
}
