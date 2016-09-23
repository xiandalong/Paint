package com.example.xiandalong.paint;


class DrawingPresenter {

    private static final int DEFAULT_COLOR = R.color.blackPaint;
    private static final int DEFAULT_SIZE = R.dimen.brush_size_1;
    private DrawingInterface view;
    private DrawingProperties properties = new DrawingProperties(DEFAULT_COLOR, DEFAULT_SIZE);

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

    void colorBlackChosen() {
        properties.setColor(R.color.blackPaint);
        view.changeToColor(properties);
        view.hideColorPanel();
        view.hideBrushSizePanel();
    }

    void colorGreyChosen() {
        properties.setColor(R.color.greyPaint);
        view.changeToColor(properties);
        view.hideColorPanel();
        view.hideBrushSizePanel();
    }

    void brushSize1Chosen() {
        properties.setBrushSize(8);
        view.changeToBrushSize(properties);
        view.hideColorPanel();
        view.hideBrushSizePanel();
    }

    void brushSize2Chosen() {
        properties.setBrushSize(12);
        view.changeToBrushSize(properties);
        view.hideColorPanel();
        view.hideBrushSizePanel();
    }

    void brushSize3Chosen() {
        properties.setBrushSize(16);
        view.changeToBrushSize(properties);
        view.hideColorPanel();
        view.hideBrushSizePanel();
    }
}
