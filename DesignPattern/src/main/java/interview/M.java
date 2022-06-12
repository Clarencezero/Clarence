package main.java.interview;


import main.java.interview.carrier.Carrier;
import main.java.interview.carrier.GlassCarrier;
import main.java.interview.pen.Pen;

public class M {
    public static void main(String[] args) {
        Pen markerPen = PenFactory.createPen(PenFactory.PenStyle.MARKER);
        // 初始化容量为50的玻璃载体
        Carrier marker = new GlassCarrier(4);

        boolean result = markerPen.writeData("hello", marker);
        System.out.println("写入结果: " + result);

        System.out.println(marker.toString());
    }
}
