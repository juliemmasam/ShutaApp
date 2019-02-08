package com.vinetworks.juliemmasam.shuta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GradesFragment extends Fragment {

    public static GradesFragment newInstance() {
        GradesFragment fragment = new GradesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grades, container, false);
        TextView courseName = (TextView) rootView.findViewById(R.id.course_name);
        courseName.setText("TE380");
        TextView grade = (TextView) rootView.findViewById(R.id.course_grade);
        grade.setText("40");
        return rootView;
    }
}
