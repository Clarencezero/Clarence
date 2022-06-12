package main.java.interview.carrier;


import main.java.interview.PenFactory;
import main.java.interview.pen.Pen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 载体抽象类
 */
public abstract class Carrier {
    // 容量
    protected int capacity;
    // 已写入数据
    protected int hadWrite;
    // 写入数据
    protected StringBuilder data = new StringBuilder();
    // 写入的笔唯一ID
    protected Map<Integer, Pen> hadWritePen = new HashMap<>();
    // 允许写入的笔
    protected List<PenFactory.PenStyle> couldWritePen = new ArrayList<>();

    public Carrier(int capacity) {
        this.capacity = capacity;
    }

    // 判断是否允许写入
    private boolean couldWrite(PenFactory.PenStyle pen, int textLength) {
        return couldWritePen.contains(pen) && capacity > (hadWrite + textLength);
    }

    // 写入data
    public boolean writeData(Pen pen, String text) {
        if (couldWrite(pen.getPenStyle(), text.length())) {
            data.append(text);
            hadWrite += text.length();
            return true;
        } else {
            return false;
        }
    }
}
