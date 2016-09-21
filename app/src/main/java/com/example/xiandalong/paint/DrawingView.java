package com.example.xiandalong.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DrawingView extends View {

    private Paint drawPaint;
    private Path path = new Path();
    private List<Path> paths = new ArrayList<>();
    private Map<Path, PaintProperties> propertyMap = new HashMap<>();

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int currentColor = drawPaint.getColor();
        int currentBrushWidth = Math.round(drawPaint.getStrokeWidth());
        for (Path p :
                paths) {
            drawPaint.setColor(propertyMap.get(p).getColor());
            drawPaint.setStrokeWidth(propertyMap.get(p).getBrushWidth());
            canvas.drawPath(p, drawPaint);
        }
        drawPaint.setColor(currentColor);
        drawPaint.setStrokeWidth(currentBrushWidth);
        canvas.drawPath(path, drawPaint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x_pos = Math.round(event.getX());
        int y_pos = Math.round(event.getY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                path.moveTo(x_pos, y_pos);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x_pos, y_pos);
                break;
            case MotionEvent.ACTION_UP:
                paths.add(path);
                propertyMap.put(path,
                                new PaintProperties(drawPaint.getColor(), Math.round(drawPaint.getStrokeWidth())));
            default:
                return false;
        }
        postInvalidate();
        return true;
    }


    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(Color.BLACK);
        drawPaint.setAntiAlias(true);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeWidth(8);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void reset() {
        path = new Path();
        paths.clear();
        invalidate();
    }

    public void setPaintColor(int color) {
        drawPaint.setColor(color);
    }

    public void setPaintWidth(int width) {
        drawPaint.setStrokeWidth(width);
    }
}
