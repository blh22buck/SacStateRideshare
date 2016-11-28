package com.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText editTextNewPassword;
    private TextView textViewAlert;
    private Button buttonChangePassword;
    private Button Buttoncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Buttoncancel = (Button) findViewById(R.id.buttonCancel);
        Buttoncancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent login = new Intent(getApplicationContext(), LoginActivity.class);

                startActivity(login);
                finish();
            }

        });

        editTextNewPassword = (EditText) findViewById(R.id.newPassword);
        textViewAlert = (TextView) findViewById(R.id.alertPassword);
        buttonChangePassword = (Button) findViewById(R.id.buttonChangePassword);
    }
}
