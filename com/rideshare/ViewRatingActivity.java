package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class ViewRatingActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editComment;

    private RatingBar rateClean;
    private RatingBar rateTime;

    private Button buttonSubmitRating;
    private Button buttonBack;

    private String comment;
    private String username;
    //private String othername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rating);

        editComment= (EditText) findViewById(R.id.ratingComment);

        rateClean = (RatingBar) findViewById(R.id.cleanRating);
        rateTime = (RatingBar) findViewById(R.id.timeRating);

        buttonSubmitRating = (Button) findViewById(R.id.submitComment);
        buttonSubmitRating.setOnClickListener(this);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v == buttonSubmitRating) {
            rate();
        }
        else if(v == buttonBack){
            finish();
        }
    }

    private void rate(){
        int userRatingClean = rateClean.getNumStars();
        int userRatingTime = rateTime.getNumStars();

        Intent intent = getIntent();

        comment = editComment.getText().toString().trim();
        username = intent.getStringExtra(LoginActivity.USER_NAME);
        //othername = intent.getStringExtra(Activity.)

        rateUser(userRatingClean, userRatingTime, comment);

    }

    private void rateUser(int ratingClean, int ratingTime, String comment){
        //rate the user some how
        finish();

    }
}
