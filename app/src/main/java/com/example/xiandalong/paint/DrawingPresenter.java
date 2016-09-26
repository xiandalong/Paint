package com.example.xiandalong.paint;


import android.graphics.Color;

class DrawingPresenter {

    private static final int DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_SIZE = R.dimen.brush_size_1;
    private DrawingInterface view;
    private DrawingProperties properties = new DrawingProperties(DEFAULT_COLOR, DEFAULT_SIZE);
    //add boolean state of buttons

    DrawingPresenter(DrawingInterface view) {
        this.view = view;
    }

    void resetButtonClicked() {
        view.resetDrawing();
    }


    void saveButtonClicked() {
        view.saveDrawing();
    }

    void colorPanelButtonClicked() {
        if (view.isColorPanelVisible()) {
            view.hideColorPanel();
        } else {
            view.showColorPanel();
        }
    }

    void brushButtonClicked() {
        if (view.isBrushSizePanelVisible()) {
            view.hideBrushSizePanel();
        } else {
            view.showBrushSizePanel();
        }
    }

    // reduce repeatition here
    void colorBlackChosen() {
        properties.setColor(Color.BLACK);
        view.changeToColor(properties);
        view.hideColorPanel();
    }

    void colorGreyChosen() {
        properties.setColor(Color.GRAY);
        view.changeToColor(properties);
        view.hideColorPanel();
    }

    void brushSize1Chosen() {
        properties.setBrushSize(8);
        view.changeToBrushSize(properties);
        view.hideBrushSizePanel();
    }

    void brushSize2Chosen() {
        properties.setBrushSize(12);
        view.changeToBrushSize(properties);
        view.hideBrushSizePanel();
    }

    void brushSize3Chosen() {
        properties.setBrushSize(16);
        view.changeToBrushSize(properties);
        view.hideBrushSizePanel();
    }
}
