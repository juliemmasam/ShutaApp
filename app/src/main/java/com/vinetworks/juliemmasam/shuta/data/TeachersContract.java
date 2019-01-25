package com.vinetworks.juliemmasam.shuta.data;

import android.provider.BaseColumns;

public final class TeachersContract {
    public final class TeachersEntry implements BaseColumns{
        // table name
        public static final String TABLE_NAME = "teachers";

        // The columns in the table
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";

    }
}
