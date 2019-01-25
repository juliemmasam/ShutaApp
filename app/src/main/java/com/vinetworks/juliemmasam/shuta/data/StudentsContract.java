package com.vinetworks.juliemmasam.shuta.data;

import android.provider.BaseColumns;

public final class StudentsContract {
    public final class StudentEntry implements BaseColumns{
        // The name of the table
        public static final String TABLE_NAME = "students";

        // The columns of the table
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
    }
}
