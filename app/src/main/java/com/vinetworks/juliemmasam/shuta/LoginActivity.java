package com.vinetworks.juliemmasam.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // Initializing all the variables to keep track of them from the UI
    EditText txtUsername, pwdPassword;
    TextView lblNotification;
    Button btnLogin, btnAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Instantiating the variables when launching the activity
        txtUsername = findViewById(R.id.txtUsername);
        lblNotification = findViewById(R.id.lbl_notification);
        pwdPassword = findViewById(R.id.pwdPassword);
        btnLogin = findViewById(R.id.btn_login);
        btnAdmin = findViewById(R.id.btn_Admin);


        // the listener for the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            /**
             * the real use of this button is to got through a series of the following
             * 1. check if the username exists in the database
             * 2. check whether or not the password exists in the database along with the username
             * 3. if the user exists, it should check the status of the user. ie whether the user
             *  is the teacher or student then decide what to open after that
             * 4. If either the user does not exist or the password is incorrect, the user should
             *  be notified by displaying the toast message
             *
             *
             *  NB: Right now check whether the fields are filled or empty
            * */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                // Find out if the values entered on the EditText Views exist in the database for authentication
                // If the values exit, set the value of the profile name on the Profile view of the application
                startActivity(intent);
            }
        });


        // the listener for the admin button
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Administrator.class);
                startActivity(intent);
            }
        });
    }

}
