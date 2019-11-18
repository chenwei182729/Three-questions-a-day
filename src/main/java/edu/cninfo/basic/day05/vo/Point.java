package edu.cninfo.basic.day05.vo;

import edu.cninfo.basic.day05.ToString;

@ToString(includeName = false)
public class Point {
    @ToString(includeName = false)
    private int x;
    @ToString(includeName = false)
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
