package com.libraryprojects.json_parsing.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.libraryprojects.json_parsing.R;

/**
 * Created by anand-trisys on 19/8/17.
 */

public class CircularView extends View
{
    private Paint paint=new Paint();
    private float centrex,centrey,radius;
    public CircularView(Context context) {
        super(context);
    }

    public CircularView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a=context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircularView,0,0);
        try{
            centrex=a.getFloat(R.styleable.CircularView_centerX,0);
            centrey=a.getFloat(R.styleable.CircularView_centerY,0);
            radius=a.getFloat(R.styleable.CircularView_radius,0);
        }
        finally{
            a.recycle();
        }

    }

    public CircularView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//    public void setCircleProperties(float centrex,float centrey,float radius){
//    this.centrex=centrex;
//        this.centrey=centrey;
//        this.radius=radius;
//    }
//    public void draw(){
//        invalidate();
//        requestLayout();;
//    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        paint.setStrokeWidth(10);//border width
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(centrex,centrey,radius,paint);
        super.onDraw(canvas);
    }
}
