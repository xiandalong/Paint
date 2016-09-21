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
    @BindView(R.id.reset)
    ImageButton resetButton;

    // color panel views
    @BindView(R.id.color_panel_button)
    ImageButton colorPanelButton;
    @BindView(R.id.color_panel)
    View colorPanel;
    @BindView(R.id.color_black_button)
    ImageButton colorBlackButton;
    @BindView(R.id.color_grey_button)
    ImageButton colorGreyButton;

    // brush size panel views
    @BindView(R.id.brush_button)
    ImageButton brushButton;
    @BindView(R.id.brush_size_panel)
    View brushSizePanel;
    @BindView(R.id.brush_size_button_1)
    View brushSizeButton1;
    @BindView(R.id.brush_size_button_2)
    View brushSizeButton2;
    @BindView(R.id.brush_size_button_3)
    View brushSizeButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupResetButton();
        setupColorPanel();
        setupBrushSizePanel();
    }

    private void setupResetButton() {
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.reset();
            }
        });
    }

    private void setupColorPanel() {
        colorPanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colorPanel.getVisibility() == View.INVISIBLE) {
                    colorPanel.setVisibility(View.VISIBLE);
                } else {
                    colorPanel.setVisibility(View.INVISIBLE);
                }
            }
        });


        colorBlackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(ContextCompat.getColor(MainActivity.this, R.color.blackPaint));
                colorPanel.setVisibility(View.INVISIBLE);
            }
        });

        colorGreyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintColor(ContextCompat.getColor(MainActivity.this, R.color.greyPaint));
                colorPanel.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void setupBrushSizePanel() {
        brushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (brushSizePanel.getVisibility() == View.INVISIBLE) {
                    brushSizePanel.setVisibility(View.VISIBLE);
                } else {
                    brushSizePanel.setVisibility(View.INVISIBLE);
                }
            }
        });
        brushSizeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintWidth(8);
                brushSizePanel.setVisibility(View.INVISIBLE);
            }
        });
        brushSizeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintWidth(12);
                brushSizePanel.setVisibility(View.INVISIBLE);
            }
        });
        brushSizeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setPaintWidth(16);
                brushSizePanel.setVisibility(View.INVISIBLE);
            }
        });

    }

}
