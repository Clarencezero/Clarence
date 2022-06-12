package main.java.interview;


import main.java.interview.pen.Marker;
import main.java.interview.pen.Pen;
import main.java.interview.pen.Pencile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PenFactory {
    private static List<Pen> procude = new ArrayList<>();
    private static List<Pen> recycle = new ArrayList<>();
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static Pen createPen(PenStyle penStyle) {
        switch (penStyle) {
            case MARKER:
                return new Marker(atomicInteger.getAndIncrement(), PenStyle.MARKER);
            case PENCIL:
                return new Pencile(atomicInteger.getAndIncrement(), PenStyle.PENCIL);
            default:
                throw new IllegalArgumentException("不能生产未知型号的笔!");
        }
    }

    /**
     * 回收笔
     *
     * @param pen
     */
    public static void recyclePen(Pen pen) {
        procude.remove(pen);
        recycle.add(pen);
    }

    public enum PenStyle {
        MARKER, PENCIL;
    }
}


