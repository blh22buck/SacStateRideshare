package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity implements View.OnClickListener{
    //public class SearchResultActivity extends Activity {
    private static String userTrip, userZip, userWeekDayTo, userWeekDayFrom, toHour, fromHour, toMinute, fromMinute, userWay;
    private static TextView banner, tellUser;
    private static Button[] resultButtons;
    private static Button button1;
    private static Button button2;
    private static int searchResultCount;
    private static String userStatus, userGender, userDisable, userNameSearch;

    String resultString;
    private static TextView userResult1;

    private static String currentUserID, currentUsername, msgUserId;
    //intent.putExtras("currentID", currentUserId);
    //intent.putExtras("msgUserID", msgUserId);



    @Override
    public void onClick(View v){
        if(v==button1){
            startActivity(new Intent(this, MessageLoginActivity.class));
        }
        if(v==button2){
            startActivity(new Intent(this, ViewProfileActivity.class));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        banner = (TextView)findViewById(R.id.searchResultBanner);
        tellUser = (TextView)findViewById(R.id.tellUser);

        Intent intent = getIntent();
        currentUsername = intent.getStringExtra(LoginActivity.USER_NAME);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button1);
        button2.setOnClickListener(this);

        userResult1 = (TextView)findViewById(R.id.resultText);
        userResult1.setText("Jason463");
        userResult1.setTextSize(18);

        userTrip = getIntent().getExtras().getString("Trip");

        userNameSearch = getIntent().getExtras().getString("username");
        //userResult1.setText(userNameSearch);




        if(userNameSearch !=null){//searching by username
            //TODO IF We are searching by username
            userResult1.setText(userNameSearch);
            //userNameSearchFunction(userNameSearch);
        }
        else{
            userZip = getIntent().getExtras().getString("Zip Code");
            userStatus = getIntent().getExtras().getString("status");
            userGender = getIntent().getExtras().getString("gender");
            userDisable = getIntent().getExtras().getString("disable");

            if(userTrip.equals("oneway")){//One Way
                userWay = getIntent().getExtras().getString("way");
                if(userWay.equals("from")){//From School
                    userWeekDayFrom = getIntent().getExtras().getString("From Day");
                    fromHour = getIntent().getExtras().getString("From hour");
                    fromMinute = getIntent().getExtras().getString("From minute");
                }
                else{ //To School
                    userWeekDayFrom = getIntent().getExtras().getString("To Day");
                    toHour = getIntent().getExtras().getString("To hour");
                    toMinute = getIntent().getExtras().getString("To minute");
                }

            }
            else{//RoundTrip
                userWeekDayTo = getIntent().getExtras().getString("To Day");//weekday ex: Mon
                userWeekDayFrom = getIntent().getExtras().getString("From Day");
                toHour = getIntent().getExtras().getString("To hour");
                fromHour = getIntent().getExtras().getString("From hour");
                toMinute = getIntent().getExtras().getString("To minute");
                fromMinute = getIntent().getExtras().getString("From minute");

            }
        }



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if(userNameSearch == null) {

            if(userTrip.equals("oneway")){
                if(userWay.equals("from")){
                    //resultString = searchFrom();
                }
                else{
                    //resultString = searchTo();
                }
                //TODO one way search

            }
            else{
                //TODO round trip search
            }

            while(searchResultCount>0){
                //create button
                //fill with id of returned result
            }

        }

    }//end onPostCreate()
}
