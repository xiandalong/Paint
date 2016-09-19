package com.example.xiandalong.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class DrawingView extends View {

    private final int paintColor = Color.BLACK;
    private Paint drawPaint;
    private List<Point> points;


    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();
        points = new ArrayList<>();
    }

    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < points.size() - 1; i++) {
            Point pre = points.get(i);
            Point post = points.get(i + 1);
            canvas.drawLine(pre.x, pre.y, post.x, post.y, drawPaint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x_pos = Math.round(event.getX());
        int y_pos = Math.round(event.getY());
        points.add(new Point(x_pos, y_pos));
        postInvalidate();
        return true;
    }
}
