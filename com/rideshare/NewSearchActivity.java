package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class NewSearchActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    private static boolean userRoundTrip = false;
    private static String userStatus;
    private static String userGender;
    private static String userDisable;
    private static TextView searchHeader, userToFromText2;


    private static final int spinnerWidth = 280;
    private static SearchView barSearch = null;// = new SearchView();
    private static final String[] rtSpinnerArray ={"One Way", "Round Trip"};
    private static final String[] statusSpinnerArray ={"Status:", "Student", "Faculty"};
    private static final String[] genderSpinnerArray ={"Gender:", "Female", "Male", "Other"};
    private static final String[] disableSpinnerArray ={"Disability:", "YES", "NO"};
    private static Button nextButton = null;
    private static Switch userToggle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_search);

        //Create Switch
        userToFromText2 = (TextView)findViewById(R.id.switchText);

        //create Search Header
        searchHeader = (TextView)findViewById(R.id.searchTextView);
        //Create Search Bar for username
        barSearch = (SearchView)findViewById(R.id.searchView);


        barSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String userQuery){
                Intent userNameSearch = new Intent(NewSearchActivity.this, SearchResultActivity.class);
                userNameSearch.putExtra("username", userQuery);
                startActivity(userNameSearch);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                //do nothing
                return true;
            }

        });
        //**************************Create Spinners
        create_and_fill_Spinners();

        //create next button
        nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(this);



    }

    public void createSwitch(){
        //Create textView for switch
        userToFromText2.setText("One Way ");
        //Create Switch
        userToggle2 = (Switch)findViewById(R.id.switch1);
        userToggle2.setChecked(true);
        userToggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "One Way", Toast.LENGTH_SHORT).show();
                    userToFromText2.setText("One Way");
                    userRoundTrip = false;
                } else {
                    Toast.makeText(getApplicationContext(), "Round Trip", Toast.LENGTH_SHORT).show();
                    userToFromText2.setText("Round Trip");
                    userRoundTrip = true;
                }
            }
        });
    }

    private void create_and_fill_Spinners(){

        //Round trip switch
        createSwitch();

        // Status Spinner
        Spinner statusSpinner = (Spinner) findViewById(R.id.statusSpinner);//spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.status_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter1 to the spinner
        statusSpinner.setAdapter(adapter1);
        statusSpinner.setOnItemSelectedListener(this);

        // Gender Spinner
        Spinner genderSpinner = (Spinner) findViewById(R.id.genderSpinner);//spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter2 to the spinner
        genderSpinner.setAdapter(adapter2);
        genderSpinner.setOnItemSelectedListener(this);

        // disable Spinner
        Spinner disableSpinner = (Spinner) findViewById(R.id.disableSpinner);//spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.disability_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter2 to the spinner
        disableSpinner.setAdapter(adapter3);
        disableSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == nextButton){
            if(userRoundTrip==true){
                //TODO start roundTrip intent
                Intent rtSearch = new Intent(NewSearchActivity.this,RoundTripSearchActivity.class);
                //zip,
                rtSearch.putExtra("status", userStatus);
                rtSearch.putExtra("gender",userGender);
                rtSearch.putExtra("disable",userDisable);
                startActivity(rtSearch);
            }
            else{
                //TODO start oneWay trip intent
                Intent owSearch = new Intent(NewSearchActivity.this,OneWaySearchActivity.class);
                //zip,
                owSearch.putExtra("status", userStatus);
                owSearch.putExtra("gender",userGender);
                owSearch.putExtra("disable", userDisable);
                startActivity(owSearch);

            }
        }
        /*if(v ==  ){
            startActivity(new Intent(this,ActivityLogin.class));
        }*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id){
        switch(parent.getId()){
            case R.id.statusSpinner: //school status
                switch(position){
                    case 0: //Status
                        userStatus=null;
                        break;
                    case 1://Student
                        userStatus = "student";
                        break;
                    case 2://faculty
                        userStatus = "faculty";
                        break;
                }
                break;
            case R.id.genderSpinner: //gender
                switch(position){
                    case 0://Gender:
                        break;
                    case 1://female
                        userGender = "female";
                        break;
                    case 2: //male
                        userGender = "male";
                        break;
                    case 3: //other
                        userGender = "other";
                        break;
                }
                break;
            case R.id.disableSpinner: //disability
                switch(position){
                    case 0://Disable
                        break;
                    case 1://yes
                        userDisable = "true";
                        break;
                    case 2: //no
                        userDisable = "no";
                        break;
                }
                break;
        }


    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0){

    }
}
