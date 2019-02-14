package com.vinetworks.juliemmasam.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vinetworks.juliemmasam.shuta.data.StudentsContract;
import com.vinetworks.juliemmasam.shuta.data.TeachersContract;
import com.vinetworks.juliemmasam.shuta.data.UsersDbHelper;

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
        btnLogin = findViewById(R.id.btn_login);
        btnAdmin = findViewById(R.id.btn_Admin);


        // the listener for the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               grantAccess();
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


    // A method to grant access to the user

    public void grantAccess(){
        if(isAuthenticatedStudent() == true){
            // start the activity for the students
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("Username", txtUsername.getText().toString());
            intent.putExtra("Status", "Student");
            startActivity(intent);

        }else if(isAuthenticatedTeacher() == true){
            // start the activity for the teachers
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("Usernname", txtUsername.getText().toString());
            intent.putExtra("Status", "Teacher");
            startActivity(intent);
        }else{
            // display the notification notifying that the information entered is wrong
            lblNotification.setText("You are not a registered user!!");
            lblNotification.setVisibility(View.VISIBLE);
        }
    }


    // the code to check whether the student exists in the database or not

    public boolean isAuthenticatedStudent(){
        // Instantiate the views before getting their values
        txtUsername = findViewById(R.id.txtUsername);
        lblNotification = findViewById(R.id.lbl_notification);
        pwdPassword = findViewById(R.id.pwdPassword);

        // instantiate the value of the existence of the user in the database
        boolean userExists;

        // Get Access to the database
        UsersDbHelper helper = new UsersDbHelper(getBaseContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        // Query parameters
        String tableName = StudentsContract.StudentEntry.TABLE_NAME;

        String[] columns = {StudentsContract.StudentEntry.COLUMN_USERNAME,
                            StudentsContract.StudentEntry.COLUMN_PASSWORD};

        String selection = StudentsContract.StudentEntry.COLUMN_USERNAME + " = ? AND " +
                            StudentsContract.StudentEntry.COLUMN_PASSWORD + " = ?";

        String[] selectionArgs = {txtUsername.getText().toString(),pwdPassword.getText().toString()};

        // Create the cursor from the query parameters
        Cursor cursor = db.query(tableName, columns, selection, selectionArgs, null, null, null);

        // use this to check for user's existence in the database
        if(cursor.moveToFirst()){
            userExists = true;
        }else{
            userExists = false;
        }

        return userExists;
    }


    // the code to check whether the teacher exists in the database

    public boolean isAuthenticatedTeacher(){
        // Instantiate the views before getting their values
        txtUsername = findViewById(R.id.txtUsername);
        lblNotification = findViewById(R.id.lbl_notification);
        pwdPassword = findViewById(R.id.pwdPassword);

        // instantiate the value of the existence of the user in the database
        boolean isAuthenticatedTeacher;

        // Get Access to the database
        UsersDbHelper helper = new UsersDbHelper(getBaseContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        // Query parameters
        String tableName = TeachersContract.TeachersEntry.TABLE_NAME;
        String[] columns = {TeachersContract.TeachersEntry.COLUMN_USERNAME, TeachersContract.TeachersEntry.COLUMN_PASSWORD};
        String selection = TeachersContract.TeachersEntry.COLUMN_USERNAME + " = ? AND " + TeachersContract.TeachersEntry.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {txtUsername.getText().toString(), pwdPassword.getText().toString()};

        // Create the cursor from the query parameters
        Cursor cursor = db.query(tableName, columns, selection, selectionArgs, null, null, null);

        // use this to check for user's existence in the database
        if(cursor.moveToFirst()){
            isAuthenticatedTeacher = true;
        }else{
            isAuthenticatedTeacher = false;
        }

        return isAuthenticatedTeacher;
    }

}
