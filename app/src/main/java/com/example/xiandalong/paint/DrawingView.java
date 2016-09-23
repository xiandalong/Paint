package com.example.xiandalong.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


public class DrawingView extends View {

    private Paint drawPaint;
    private Path path = new Path();
    private Bitmap cacheBitmap;
    private Canvas drawCanvas;


    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cacheBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(cacheBitmap);
        drawCanvas.drawColor(Color.WHITE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(cacheBitmap, 0, 0, null);
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
                drawCanvas.drawPath(path, drawPaint);
                path.reset();
            default:
                return false;
        }
        postInvalidate();
        return true;
    }


    private void setupPaint() {
        drawPaint = new Paint(Paint.DITHER_FLAG);
        drawPaint.setColor(Color.BLACK);
        drawPaint.setAntiAlias(true);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeWidth(8);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void reset() {
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public void setPaintColor(int color) {
        drawPaint.setColor(color);
    }

    public void setPaintWidth(int width) {
        drawPaint.setStrokeWidth(width);
    }


    public void saveBitmap() {

        try {
            File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File fullPath = new File(file.getAbsolutePath() + "/" + UUID.randomUUID().toString() + ".png");
            FileOutputStream fos = new FileOutputStream(fullPath);
            cacheBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            Toast.makeText(getContext(), "Your drawing is saved!", Toast.LENGTH_LONG).show();
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
