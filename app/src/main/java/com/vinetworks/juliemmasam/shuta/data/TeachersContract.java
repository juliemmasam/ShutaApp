package com.vinetworks.juliemmasam.shuta.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class TeachersContract {

    static final String CONTENT_AUTHORITY = "com.vinetworks.juliemmasam.shuta";
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    static final String PATH_TEACHERS = "teachers";
    static final String PATH_TEACHERS_ID = "teachers/#";

    public final class TeachersEntry implements BaseColumns{

        public final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_TEACHERS);

        // table name
        public static final String TABLE_NAME = "teachers";

        // The columns in the table
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";

    }
}
