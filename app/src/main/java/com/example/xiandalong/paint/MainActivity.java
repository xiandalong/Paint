package com.example.xiandalong.paint;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawing_view)
    DrawingView drawingView;
    @BindView(R.id.reset_image_view)
    ImageButton viewReset;
    @BindView(R.id.select_color_black)
    ImageButton viewSelectColorBlack;
    @BindView(R.id.select_color_grey)
    ImageButton viewSelectColorGrey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.reset();
            }
        });

        viewSelectColorBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(ContextCompat.getColor(MainActivity.this, R.color.blackPaint));
            }
        });

        viewSelectColorGrey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(ContextCompat.getColor(MainActivity.this, R.color.greyPaint));
            }
        });
    }
}
