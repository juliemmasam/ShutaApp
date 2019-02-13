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

import com.vinetworks.juliemmasam.shuta.data.StudentsContract;
import com.vinetworks.juliemmasam.shuta.data.TeachersContract;
import com.vinetworks.juliemmasam.shuta.data.UsersDbHelper;

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
        String strTeacherName = teacherName.getText().toString().trim();
        String strTeacherUsername = teacherUsername.getText().toString().trim();
        String strTeacherPwd = teacherPassword.getText().toString().trim();

        // Add the values to the database.
        UsersDbHelper dbHelper = new UsersDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues teacherValues = new ContentValues();
        teacherValues.put(TeachersContract.TeachersEntry.COLUMN_NAME, strTeacherName);
        teacherValues.put(TeachersContract.TeachersEntry.COLUMN_USERNAME, strTeacherUsername);
        teacherValues.put(TeachersContract.TeachersEntry.COLUMN_PASSWORD, strTeacherPwd);

        long rowid = db.insert(TeachersContract.TeachersEntry.TABLE_NAME, null, teacherValues);
        Log.i("Adding Teachers", "addTeacherToDatabase: " + rowid);

        Toast.makeText(getBaseContext(), "Values successfully added", Toast.LENGTH_LONG).show();
    }
}
