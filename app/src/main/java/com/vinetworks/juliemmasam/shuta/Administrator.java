package com.vinetworks.juliemmasam.shuta;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.vinetworks.juliemmasam.shuta.data.CourseContract;
import com.vinetworks.juliemmasam.shuta.data.StudentsContract;
import com.vinetworks.juliemmasam.shuta.data.TeachersContract;
import com.vinetworks.juliemmasam.shuta.data.UsersDbHelper;

public class Administrator extends AppCompatActivity {

    Button addTeachers, addStudents, addCourses, deleteAllEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        addTeachers = findViewById(R.id.btn_add_teacher);
        addStudents = findViewById(R.id.btn_add_student);
        addCourses = findViewById(R.id.btn_add_course);
        deleteAllEntries = findViewById(R.id.btn_delete_all_entries);

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

        deleteAllEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersDbHelper helper = new UsersDbHelper(getBaseContext());
                SQLiteDatabase db = helper.getWritableDatabase();

                db.delete(StudentsContract.StudentEntry.TABLE_NAME, null, null);
                db.delete(CourseContract.CourseEntry.TABLE_NAME, null, null);
                db.delete(TeachersContract.TeachersEntry.TABLE_NAME, null, null);
            }
        });
    }
}
