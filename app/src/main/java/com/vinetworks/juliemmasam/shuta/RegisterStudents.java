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
import com.vinetworks.juliemmasam.shuta.data.UsersDbHelper;

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
        String strStudentName = studentName.getText().toString().trim();
        String strStudentUsername = studentUsername.getText().toString().trim();
        String strStudentPwd = studentPassword.getText().toString().trim();

        // Add the values to the database.
        UsersDbHelper dbHelper = new UsersDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues studentValues = new ContentValues();
        studentValues.put(StudentsContract.StudentEntry.COLUMN_NAME, strStudentName);
        studentValues.put(StudentsContract.StudentEntry.COLUMN_USERNAME, strStudentUsername);
        studentValues.put(StudentsContract.StudentEntry.COLUMN_PASSWORD, strStudentPwd);

        long rowid = db.insert(StudentsContract.StudentEntry.TABLE_NAME, null, studentValues);
        Log.i("Adding", "addStudentToDatabase: " + rowid);


        Toast.makeText(getBaseContext(), "Values successfully added", Toast.LENGTH_LONG).show();
    }
}
