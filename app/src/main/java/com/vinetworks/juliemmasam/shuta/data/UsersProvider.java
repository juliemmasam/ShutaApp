package com.vinetworks.juliemmasam.shuta.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.vinetworks.juliemmasam.shuta.data.UsersContract.CONTENT_AUTHORITY;

import static com.vinetworks.juliemmasam.shuta.data.TeachersContract.PATH_TEACHERS;
import static com.vinetworks.juliemmasam.shuta.data.TeachersContract.PATH_TEACHERS_ID;
import com.vinetworks.juliemmasam.shuta.data.TeachersContract.TeachersEntry;

import static com.vinetworks.juliemmasam.shuta.data.StudentsContract.PATH_STUDENTS;
import static com.vinetworks.juliemmasam.shuta.data.StudentsContract.PATH_STUDENTS_ID;
import com.vinetworks.juliemmasam.shuta.data.StudentsContract.StudentEntry;

import static com.vinetworks.juliemmasam.shuta.data.CourseContract.PATH_COURSES;
import static com.vinetworks.juliemmasam.shuta.data.CourseContract.PATH_COURSES_ID;
import com.vinetworks.juliemmasam.shuta.data.CourseContract.CourseEntry;

public class UsersProvider extends ContentProvider {
    private static final int COURSES = 100;
    private static final int COURSES_ID = 101;
    private static final int STUDENTS = 200;
    private static final int STUDENTS_ID = 201;
    private static final int TEACHERS = 300;
    private static final int TEACHERS_ID = 301;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(CONTENT_AUTHORITY, PATH_TEACHERS, TEACHERS);
        sUriMatcher.addURI(CONTENT_AUTHORITY, PATH_TEACHERS_ID, TEACHERS_ID);
        sUriMatcher.addURI(CONTENT_AUTHORITY, PATH_STUDENTS, STUDENTS);
        sUriMatcher.addURI(CONTENT_AUTHORITY, PATH_STUDENTS_ID, STUDENTS_ID);
        sUriMatcher.addURI(CONTENT_AUTHORITY, PATH_COURSES, COURSES);
        sUriMatcher.addURI(CONTENT_AUTHORITY, PATH_COURSES_ID, COURSES_ID);
    }

    private UsersDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new UsersDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);

        switch (match){
            case TEACHERS:
                cursor = database.query(TeachersContract.TeachersEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            case TEACHERS_ID:
                cursor = database.query(TeachersContract.TeachersEntry._ID, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            case STUDENTS:
                cursor = database.query(StudentsContract.StudentEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;


            case STUDENTS_ID:
                cursor = database.query(StudentsContract.StudentEntry._ID, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            case COURSES:
                cursor = database.query(CourseContract.CourseEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            case COURSES_ID:
                cursor = database.query(CourseContract.CourseEntry._ID, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown Uri " + uri);
        }

        return cursor;
    }


    @Override
    public String getType(@NonNull Uri uri) {   return null; }


    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase usersDb = mDbHelper.getWritableDatabase();

        final int match = sUriMatcher.match(uri);

        switch (match){
            case TEACHERS:
                long newTeacherRowId = usersDb.insert(TeachersEntry.TABLE_NAME, null, contentValues);
                return ContentUris.withAppendedId(uri, newTeacherRowId);

            case STUDENTS:
                long newStudentRowId = usersDb.insert(StudentEntry.TABLE_NAME, null, contentValues);
                return ContentUris.withAppendedId(uri, newStudentRowId);

            case COURSES:
                long newCourseId = usersDb.insert(CourseEntry.TABLE_NAME, null, contentValues);
                return ContentUris.withAppendedId(uri, newCourseId);

            default:
                throw new IllegalArgumentException("insertion is not supported for " + uri);
        }
    }


    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }


    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values,
                      @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

}
