package main.java.interview.carrier;


import main.java.interview.PenFactory;

public class GlassCarrier extends Carrier{
    public GlassCarrier(int capacity) {
        super(capacity);
        couldWritePen.add(PenFactory.PenStyle.MARKER);
    }

    @Override
    public String toString() {
        return "载体为: 玻璃。总容量: " + super.capacity + "; 剩余容量: " + (super.capacity - super.hadWrite) + "; 已写入信息: " + super.data.toString();
    }
}
