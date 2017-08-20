package com.libraryprojects.json_parsing.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by anand-trisys on 19/8/17.
 */

public class LineView extends View
{
    private Paint paint=new Paint();
    private PointF pointA,pointB;
    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        canvas.drawLine(pointA.x,pointA.y,pointB.x,pointB.y,paint);
        super.draw(canvas);
    }

    public void setPointA(PointF point){
        pointA=point;
    }
    public void setPointB(PointF point){
        pointB=point;
    }
    public void draw(){
        invalidate();
        requestLayout();
    }
}
