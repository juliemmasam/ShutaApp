package com.vinetworks.juliemmasam.shuta;

import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    private String username, status;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView txtUsername = rootView.findViewById(R.id.txtUsername);
        TextView txtTitle = rootView.findViewById(R.id.txtTitle);


        txtUsername.setText(username);
        txtTitle.setText(status);

        return rootView;
    }

    public void setUserValues(String username, String status){
        this.username = username;
        this.status = status;
    }
}
