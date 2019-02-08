package com.vinetworks.juliemmasam.shuta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CoursesFragment extends Fragment {

    public static CoursesFragment newInstance() {
        CoursesFragment fragment = new CoursesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_courses, container, false);
        TextView codeView = (TextView) rootView.findViewById(R.id.course_code);
        codeView.setText("TE380");
        TextView nameView = (TextView) rootView.findViewById(R.id.course_name);
        nameView.setText("DSP");
        return rootView;
    }
}
