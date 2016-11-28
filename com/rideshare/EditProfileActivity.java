package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    private EditText editTextName;
    private EditText editTextGender;
    private EditText editTextEmail;
    private EditText editTextZipCode;
    private EditText editTextToSchool;
    private EditText editTextLeaveSchool;
    private EditText editTextRelation;
    private EditText editTextPassword;

    private Button buttonSubmitEdit;
    private Button buttonBack;

    private static String userRole;

    // School server
    private static final String REGISTER_URL = "http://athena.ecs.csus.edu/~zendejaj/rideshare/UserRegistration/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editTextToSchool = (EditText) findViewById(R.id.editText_ToSchool);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextLeaveSchool = (EditText) findViewById(R.id.editText_LeaveSchool);
        editTextZipCode = (EditText) findViewById(R.id.editText_zipcode);
        editTextPassword = (EditText) findViewById(R.id.editText_Password);

        buttonSubmitEdit = (Button) findViewById(R.id.button_submit_edit);
        buttonSubmitEdit.setOnClickListener(this);

        create_and_fill_Spinners();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonSubmitEdit){
            //editUser();
            startActivity(new Intent(this, ProfileActivity.class));
        }
        if(v == buttonBack){
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
    public void editUser() {
        String name = editTextName.getText().toString().trim().toLowerCase();
        String gender = editTextGender.getText().toString().trim().toLowerCase();
        String relation = editTextRelation.getText().toString().trim().toLowerCase();
        String email = editTextEmail.getText().toString().trim().toLowerCase();

        update(name, gender, relation, email);
    }

    private void update(String name, String gender, String password, String email){

    }

    private void create_and_fill_Spinners() {

        // Role Spinner
        Spinner roleSpinner = (Spinner) findViewById(R.id.role_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter1 to the spinner
        roleSpinner.setAdapter(adapter);
        roleSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()){
            case R.id.register_gender_spinner: //spinner3: //gender
                switch(position){
                    case 0://Gender:
                        userRole = "Driver/Passenger";
                        break;
                    case 1://male
                        userRole = "Driver";
                        break;
                    case 2: //female
                        userRole = "Passenger";
                        break;
                }
                //Toast.makeText(RegisterActivity.this, "userRole = " + userRole, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
