package com.vinetworks.juliemmasam.shuta.data;

import android.provider.BaseColumns;

public final class CourseContract {
    public final class CourseEntry implements BaseColumns{
        // table name
        public static final String TABLE_NAME = "courses";

        // the columns in the table
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_COURSE_CODE = "course_code";
        public static final String COLUMN_COURSE_NAME = "course_name";
    }
}
