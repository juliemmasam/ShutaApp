package com.vinetworks.juliemmasam.shuta.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class StudentsContract {

    static final String CONTENT_AUTHORITY = "com.vinetworks.juliemmasam.shuta";
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    static final String PATH_STUDENTS = "students";
    static final String PATH_STUDENTS_ID = "students/#";

    public final class StudentEntry implements BaseColumns{

        public final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_STUDENTS);

        // The name of the table
        public static final String TABLE_NAME = "students";

        // The columns of the table
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
    }
}
