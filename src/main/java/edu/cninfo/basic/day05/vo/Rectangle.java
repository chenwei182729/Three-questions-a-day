package edu.cninfo.basic.day05.vo;

import edu.cninfo.basic.day05.ToString;

@ToString(includeName = false)
public class Rectangle {
    @ToString(includeName = false)
    private Point topLeft;
    @ToString(includeName = false)
    private int width;
    @ToString(includeName = false)
    private int height;

    public Rectangle(Point topLeft,int width,int height) {
        this(width,height);
        this.topLeft = topLeft;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
