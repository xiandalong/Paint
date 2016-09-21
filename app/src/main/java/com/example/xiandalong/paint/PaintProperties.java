package com.example.xiandalong.paint;


public class PaintProperties {
    private int color;
    private int brushWidth;

    public PaintProperties(int color, int brushWidth) {
        this.color = color;
        this.brushWidth = brushWidth;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBrushWidth() {
        return brushWidth;
    }

    public void setBrushWidth(int brushWidth) {
        this.brushWidth = brushWidth;
    }
}
