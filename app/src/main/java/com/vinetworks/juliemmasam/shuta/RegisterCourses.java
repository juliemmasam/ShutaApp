package com.vinetworks.juliemmasam.shuta;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vinetworks.juliemmasam.shuta.data.CourseContract;
import com.vinetworks.juliemmasam.shuta.data.StudentsContract;
import com.vinetworks.juliemmasam.shuta.data.UsersDbHelper;

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
        String strCourseCode = courseCode.getText().toString().trim();
        String strCourseName = courseName.getText().toString().trim();

        // Add the values to the database.
        UsersDbHelper dbHelper = new UsersDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues courseValues = new ContentValues();
        courseValues.put(CourseContract.CourseEntry.COLUMN_COURSE_CODE, strCourseCode);
        courseValues.put(CourseContract.CourseEntry.COLUMN_COURSE_NAME, strCourseName);

        long rowid = db.insert(CourseContract.CourseEntry.TABLE_NAME, null, courseValues);
        Log.i("Adding Course", "addCourseToDatabase: " + rowid);

        Toast.makeText(getBaseContext(), "Values successfully added", Toast.LENGTH_LONG).show();
    }
}
