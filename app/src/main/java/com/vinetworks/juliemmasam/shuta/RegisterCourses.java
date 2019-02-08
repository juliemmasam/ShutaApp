package com.vinetworks.juliemmasam.shuta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterCourses extends AppCompatActivity {

    EditText courseCode, courseName;
    Button btnRegisterCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_courses);

        // Initialize the variables
        courseCode = findViewById(R.id.course_code);
        courseName = findViewById(R.id.course_name);
        btnRegisterCourse = findViewById(R.id.btn_register_course);

        btnRegisterCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerCourseToDatabase();
            }
        });
    }


    // The code to add the course to the database
    private void registerCourseToDatabase(){

        // Retrieve the input values
        String strCourseCode = courseCode.toString().trim();
        String strCourseName = courseName.toString().trim();

        // Add the values to the database.

    }
}
