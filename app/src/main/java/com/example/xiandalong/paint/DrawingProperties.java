package com.example.xiandalong.paint;


class DrawingProperties {
    private int color;
    private int brushSize;

    DrawingProperties(int color, int brushSize) {
        this.color = color;
        this.brushSize = brushSize;
    }

    int getColor() {
        return color;
    }

    void setColor(int color) {
        this.color = color;
    }

    int getBrushSize() {
        return brushSize;
    }

    void setBrushSize(int brushSize) {
        this.brushSize = brushSize;
    }
}
