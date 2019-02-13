package com.vinetworks.juliemmasam.shuta;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.vinetworks.juliemmasam.shuta.data.CourseContract;
import com.vinetworks.juliemmasam.shuta.data.CoursesAdapter;
import com.vinetworks.juliemmasam.shuta.data.UsersDbHelper;
import com.vinetworks.juliemmasam.shuta.models.Course;

import java.util.ArrayList;

public class CoursesFragment extends Fragment {

    public static CoursesFragment newInstance() {
        CoursesFragment fragment = new CoursesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_courses, container, false);
        displayCourseList(rootView);
        return rootView;
    }

    public void displayCourseList(View view){
        UsersDbHelper dbHelper = new UsersDbHelper(getContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] projections = {
                CourseContract.CourseEntry.COLUMN_COURSE_CODE,
                CourseContract.CourseEntry.COLUMN_COURSE_NAME
        };

        Cursor cursor = db.query(CourseContract.CourseEntry.TABLE_NAME,
                                null, null, null,
                        null, null, null);

        ListView courseListView = view.findViewById(R.id.courses_list);

//        ArrayList coursesList = new ArrayList();
//
        while(cursor.moveToNext()){
            Course course = new Course();

            course.setId(cursor.getLong(0));
            course.setCourseCode(cursor.getString(1));
            course.setCourseName(cursor.getString(2));

            Log.i("displayCourseList:", course.toString());
        }

//        CoursesAdapter adapter = new CoursesAdapter(getContext(), cursor);
        CoursesAdapter adapter = new CoursesAdapter(getContext(), cursor);

        courseListView.setAdapter(adapter);
    }
}
