package com.vinetworks.juliemmasam.shuta.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vinetworks.juliemmasam.shuta.data.StudentsContract.StudentEntry;

public class StudentsDbHelper extends SQLiteOpenHelper {

    // Name of the database
    private static final String DATABASE_NAME = "users.db";

    // the database version
    private static final int DATABASE_VERSION = 1;


    public StudentsDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_STUDENTS_TABLE = "CREATE TABLE " + StudentEntry.TABLE_NAME + "("
                + StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StudentEntry.COLUMN_NAME + " TEXT PRIMARY KEY, "
                + StudentEntry.COLUMN_USERNAME + " TEXT NOT NULL, "
                + StudentEntry.COLUMN_PASSWORD + " TEXT NOT NULL);";

        // the statement to create the table that runs in the db
        db.execSQL(SQL_CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
