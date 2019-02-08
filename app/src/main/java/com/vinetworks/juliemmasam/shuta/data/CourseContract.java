package com.vinetworks.juliemmasam.shuta.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class CourseContract {

    static final String CONTENT_AUTHORITY = "com.vinetworks.juliemmasam.shuta";
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    static final String PATH_COURSES = "courses";
    static final String PATH_COURSES_ID = "courses/#";


    public final class CourseEntry implements BaseColumns{

        public final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_COURSES);

        // table name
        public static final String TABLE_NAME = "courses";

        // the columns in the table
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_COURSE_CODE = "course_code";
        public static final String COLUMN_COURSE_NAME = "course_name";
    }
}
