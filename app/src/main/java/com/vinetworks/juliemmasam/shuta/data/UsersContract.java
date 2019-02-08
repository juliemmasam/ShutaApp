package com.vinetworks.juliemmasam.shuta.data;

import android.net.Uri;

public class UsersContract {
    public static final String CONTENT_AUTHORITY = "com.vinetworks.juliemmasam.shuta";
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private UsersContract(){ }
}
