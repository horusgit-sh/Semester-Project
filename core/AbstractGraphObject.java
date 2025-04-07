package core;

import java.awt.*;

public abstract class AbstractGraphObject {
    protected Point pozice;
    protected Color barva;
    protected boolean filled = true;

    public AbstractGraphObject(Point pozice, Color barva) {
        this.pozice = pozice;
        this.barva = barva;
    }

    public Point getPozice() {
        return pozice;
    }

    public void setPozice(Point pozice) {
        this.pozice = pozice;
    }

    public Color getBarva() {
        return barva;
    }

    public void setBarva(Color barva) {
        this.barva = barva;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract void draw(Graphics2D g);
    public abstract boolean obsahuje(int x, int y);
}
