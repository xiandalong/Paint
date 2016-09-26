package com.example.xiandalong.paint;


interface DrawingInterface {

    void resetDrawing();

    void saveDrawing();

    boolean isColorPanelVisible();

    void hideColorPanel();

    void showColorPanel();

    boolean isBrushSizePanelVisible();

    void hideBrushSizePanel();

    void showBrushSizePanel();

    // arg should be color
    void changeToColor(DrawingProperties properties);

    void changeToBrushSize(DrawingProperties properties);

}
