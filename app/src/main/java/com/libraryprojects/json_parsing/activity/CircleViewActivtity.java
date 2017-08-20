package com.libraryprojects.json_parsing.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.libraryprojects.json_parsing.R;
import com.libraryprojects.json_parsing.customviews.CircularView;

public class CircleViewActivtity extends AppCompatActivity
{
    private CircularView circularView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_view_activtity);
//        circularView=(CircularView) findViewById(R.id.circleView);
//        circularView.setCircleProperties(350,500,200);
//        circularView.draw();
    }
}
