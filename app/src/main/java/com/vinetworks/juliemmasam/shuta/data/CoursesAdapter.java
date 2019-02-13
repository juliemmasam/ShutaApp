package com.vinetworks.juliemmasam.shuta.data;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vinetworks.juliemmasam.shuta.R;

public class CoursesAdapter extends CursorAdapter {
    public CoursesAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.course_list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView courseCode = view.findViewById(R.id.course_code);
        TextView courseName = view.findViewById(R.id.course_name);

        int codeColumnIndex = cursor.getColumnIndex(CourseContract.CourseEntry.COLUMN_COURSE_CODE);
        int nameColumnIndex = cursor.getColumnIndex(CourseContract.CourseEntry.COLUMN_COURSE_NAME);

        String code = cursor.getString(1);
        String name = cursor.getString(2);

        courseCode.setText(code);
        courseName.setText(name);
    }
}
