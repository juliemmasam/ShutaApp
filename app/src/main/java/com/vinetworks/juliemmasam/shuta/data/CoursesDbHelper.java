package com.vinetworks.juliemmasam.shuta.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vinetworks.juliemmasam.shuta.data.CourseContract.CourseEntry;


public class CoursesDbHelper extends SQLiteOpenHelper {

    // Name of the database
    private static final String DATABASE_NAME = "users.db";

    // the database version
    private static final int DATABASE_VERSION = 1;


    public CoursesDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_COURSES_TABLE = "CREATE TABLE " + CourseEntry.TABLE_NAME + "("
                + CourseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CourseEntry.COLUMN_COURSE_CODE + " TEXT PRIMARY KEY, "
                + CourseEntry.COLUMN_COURSE_NAME + " TEXT NOT NULL);";

        // the statement to create the table that runs in the db
        db.execSQL(SQL_CREATE_COURSES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
