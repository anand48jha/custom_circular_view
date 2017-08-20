package com.libraryprojects.json_parsing.activity;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.libraryprojects.json_parsing.R;
import com.libraryprojects.json_parsing.customviews.LineView;

public class LineViewActivity extends AppCompatActivity
{
    private LineView lineView;
    private PointF pointA=new PointF(200,200);
    private PointF pointB=new PointF(200,600);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_view);
        lineView=(LineView) findViewById(R.id.lineview);
        lineView.setPointA(pointA);
        lineView.setPointB(pointB);
        lineView.draw();
    }
}
