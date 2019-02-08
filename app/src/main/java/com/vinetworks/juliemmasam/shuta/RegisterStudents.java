package com.vinetworks.juliemmasam.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterStudents extends AppCompatActivity {

    EditText studentName, studentUsername, studentPassword;
    Button btnRegisterStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_students);

        // Initialize the variables
        studentName = findViewById(R.id.student_name);
        studentUsername = findViewById(R.id.student_user_name);
        studentPassword = findViewById(R.id.student_password);

        btnRegisterStudent = findViewById(R.id.btn_register_student);


        btnRegisterStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentToDatabase();
            }
        });
    }


    private void addStudentToDatabase(){
        // Retrieve the input values
        String strStudentName = studentName.toString().trim();
        String strStudentUsername = studentUsername.toString().trim();
        String strStudentPwd = studentPassword.toString().trim();

        // Add the values to the database.
    }
}
