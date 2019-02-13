package com.vinetworks.juliemmasam.shuta.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vinetworks.juliemmasam.shuta.data.CourseContract.CourseEntry;
import com.vinetworks.juliemmasam.shuta.data.StudentsContract.StudentEntry;
import com.vinetworks.juliemmasam.shuta.data.TeachersContract.TeachersEntry;


public class UsersDbHelper extends SQLiteOpenHelper {

    // Name of the database
    private static final String DATABASE_NAME = "users.db";

    // the database version
    private static final int DATABASE_VERSION = 1;

    public UsersDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the Courses table in the database
        String SQL_CREATE_COURSES_TABLE = "CREATE TABLE IF NOT EXISTS " + CourseEntry.TABLE_NAME + "("
                + CourseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CourseEntry.COLUMN_COURSE_CODE + " TEXT NOT NULL, "
                + CourseEntry.COLUMN_COURSE_NAME + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_COURSES_TABLE);


        // Create the Students table in the database
        String SQL_CREATE_STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS " + StudentEntry.TABLE_NAME + "("
                + StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StudentEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + StudentEntry.COLUMN_USERNAME + " TEXT NOT NULL, "
                + StudentEntry.COLUMN_PASSWORD + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_STUDENTS_TABLE);


        // Create the Teachers table in the database
        String SQL_CREATE_TEACHERS_TABLE = "CREATE TABLE IF NOT EXISTS " + TeachersEntry.TABLE_NAME + "("
                + TeachersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TeachersEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + TeachersEntry.COLUMN_USERNAME + " TEXT NOT NULL, "
                + TeachersEntry.COLUMN_PASSWORD + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_TEACHERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Left for future use
    }
}
