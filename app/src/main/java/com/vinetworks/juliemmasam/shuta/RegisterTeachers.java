package com.vinetworks.juliemmasam.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterTeachers extends AppCompatActivity {

    EditText teacherName, teacherUsername , teacherPassword;
    Button btnRegisterTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Start Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_teachers);

        // Initialize the values of the EditText gotten
        teacherName = findViewById(R.id.teacher_name);
        teacherUsername = findViewById(R.id.teacher_user_name);
        teacherPassword = findViewById(R.id.teacher_password);

        btnRegisterTeacher = findViewById(R.id.btn_register_teacher);


        btnRegisterTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              addTeacherToDatabase();
            }
        });
    }


    private void addTeacherToDatabase(){
        // Retrieve the input values
        String strTeacherName = teacherName.toString().trim();
        String strTeacherUsername = teacherUsername.toString().trim();
        String strTeacherPwd = teacherPassword.toString().trim();

        // Add the values to the database.
    }
}
