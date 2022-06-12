package main.java.interview.pen;


import main.java.interview.PenFactory;
import main.java.interview.carrier.Carrier;

public abstract class Pen {
    private int id;
    PenFactory.PenStyle penStyle;
    public Pen(int id, PenFactory.PenStyle penStyle) {
        this.id = id;
        this.penStyle = penStyle;
    }

    public PenFactory.PenStyle getPenStyle() {
        return penStyle;
    }

    public boolean writeData(String text, Carrier marker) {
        return marker.writeData(this, text);
    }
}
