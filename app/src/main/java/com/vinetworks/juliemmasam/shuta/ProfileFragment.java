package com.vinetworks.juliemmasam.shuta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.txtUsername);
        textView.setText("EMMANUEL");
        return rootView;
    }
}
