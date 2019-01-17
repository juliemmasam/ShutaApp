package com.vinetworks.juliemmasam.shuta.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vinetworks.juliemmasam.shuta.data.TeachersContract.TeachersEntry;

public class TeachersDbHelper extends SQLiteOpenHelper {

    // Name of the database
    private static final String DATABASE_NAME = "users.db";

    // the database version
    private static final int DATABASE_VERSION = 1;


    public TeachersDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_COURSES_TABLE = "CREATE TABLE " + TeachersEntry.TABLE_NAME + "("
                + TeachersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TeachersEntry.COLUMN_NAME + " TEXT PRIMARY KEY, "
                + TeachersEntry.COLUMN_USERNAME + " TEXT NOT NULL, "
                + TeachersEntry.COLUMN_PASSWORD + " TEXT NOT NULL);";

        // the statement to create the table that runs in the db
        db.execSQL(SQL_CREATE_COURSES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
