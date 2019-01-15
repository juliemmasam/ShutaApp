package com.vinetworks.juliemmasam.shuta;

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
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Instantiating the variables when launching the activity
        txtUsername = findViewById(R.id.txtUsername);
        lblNotification = findViewById(R.id.lbl_notification);
        pwdPassword = findViewById(R.id.pwdPassword);
        btnLogin = findViewById(R.id.btn_login);


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
                //Check if the fields are filled
                if(txtUsername.getText() == null || pwdPassword.getText() == null){
                    lblNotification.setText("One of the fields empty.");
                    lblNotification.setVisibility(View.VISIBLE);
                }else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // this is where we can check if the entries are in the database
                            
                        }
                    }).start();
                }
            }
        });
    }

}
