package com.example.xiandalong.paint;


class DrawingPresenter {

    private DrawingInterface view;

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
        view.changeColorPanelVisibility();
    }

    void brushButtonClicked() {
        view.changeBrushSizePanelVisibility();
    }

    void colorBlackChosen() {
        view.changeToColorBlack();
    }

    void colorGreyChosen() {
        view.changeToColorGrey();
    }

    void brushSize1Chosen() {
        view.changeToBrushSize1();
    }

    void brushSize2Chosen() {
        view.changeToBrushSize2();
    }

    void brushSize3Chosen() {
        view.changeToBrushSize3();
    }
}
