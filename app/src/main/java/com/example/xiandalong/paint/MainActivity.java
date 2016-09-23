package com.example.xiandalong.paint;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements DrawingInterface {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private DrawingPresenter presenter;

    @BindView(R.id.drawing_view)
    DrawingView drawingView;
    @BindView(R.id.reset)
    ImageButton resetButton;

    // color panel views
    @BindView(R.id.color_panel_button)
    ImageButton colorPanelButton;
    @BindView(R.id.color_panel)
    LinearLayout colorPanel;
    @BindView(R.id.color_black_button)
    ImageButton colorBlackButton;
    @BindView(R.id.color_grey_button)
    ImageButton colorGreyButton;

    // brush size panel views
    @BindView(R.id.brush_button)
    ImageButton brushButton;
    @BindView(R.id.brush_size_panel)
    LinearLayout brushSizePanel;
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

        presenter = new DrawingPresenter(this);
        setupResetButton();
        setupColorPanel();
        setupBrushSizePanel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_button:
                presenter.saveButtonClicked();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void changeColorPanelVisibility() {
        if (colorPanel.getVisibility() == View.INVISIBLE) {
            colorPanel.setVisibility(View.VISIBLE);
        } else {
            colorPanel.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void changeBrushSizePanelVisibility() {
        if (brushSizePanel.getVisibility() == View.INVISIBLE) {
            brushSizePanel.setVisibility(View.VISIBLE);
        } else {
            brushSizePanel.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void changeToColorBlack() {
        drawingView.setPaintColor(ContextCompat.getColor(MainActivity.this, R.color.blackPaint));
        colorPanel.setVisibility(View.INVISIBLE);
    }

    @Override
    public void changeToColorGrey() {
        drawingView.setPaintColor(ContextCompat.getColor(MainActivity.this, R.color.greyPaint));
        colorPanel.setVisibility(View.INVISIBLE);
    }

    @Override
    public void changeToBrushSize1() {
        drawingView.setPaintWidth(8);
        brushSizePanel.setVisibility(View.INVISIBLE);
    }

    @Override
    public void changeToBrushSize2() {
        drawingView.setPaintWidth(12);
        brushSizePanel.setVisibility(View.INVISIBLE);
    }

    @Override
    public void changeToBrushSize3() {
        drawingView.setPaintWidth(16);
        brushSizePanel.setVisibility(View.INVISIBLE);
    }

    @Override
    public void resetDrawing() {
        drawingView.reset();
    }

    @Override
    public void saveDrawing() {
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
        drawingView.saveBitmap();
    }

    private void setupResetButton() {
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.resetButtonClicked();
            }
        });
    }

    private void setupColorPanel() {
        colorPanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.colorPanelButtonClicked();
            }
        });


        colorBlackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.colorBlackChosen();
            }
        });

        colorGreyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.colorGreyChosen();
            }
        });
    }

    private void setupBrushSizePanel() {
        brushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.brushButtonClicked();
            }
        });
        brushSizeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.brushSize1Chosen();
            }
        });
        brushSizeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.brushSize2Chosen();
            }
        });
        brushSizeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.brushSize3Chosen();
            }
        });

    }


}
