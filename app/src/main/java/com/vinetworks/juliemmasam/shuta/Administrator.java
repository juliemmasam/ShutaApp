package com.vinetworks.juliemmasam.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Administrator extends AppCompatActivity {

    Button addTeachers, addStudents, addCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        addTeachers = findViewById(R.id.btn_add_teacher);
        addStudents = findViewById(R.id.btn_add_student);
        addCourses = findViewById(R.id.btn_add_course);

        // Setting up the listeners
        addTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterTeachers.class));
            }
        });

        addStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterStudents.class));
            }
        });

        addCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterCourses.class));
            }
        });
    }
}
