package jianzhioffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class No_59_MaxQueue {
    // 队列中的最大值
    // 队列：先进先出
    // 最大值：动态的，改变的
    private Deque<Integer> dataQueue;
    private Deque<Integer> decreseQueue;

    public static void main(String[] args) {
        No_59_MaxQueue go = new No_59_MaxQueue();
        go.push_back(15);
        System.out.println(go.max_value());

        go.push_back(15);
        System.out.println(go.max_value());

        go.push_back(14);
        System.out.println(go.pop_front());
        System.out.println(go.max_value());
        System.out.println(go.pop_front());
        System.out.println(go.max_value());
        System.out.println(go.pop_front());
        System.out.println(go.max_value());
    }

    public No_59_MaxQueue() {
        dataQueue = new ArrayDeque<>();
        decreseQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (decreseQueue.isEmpty()) return -1;

        return decreseQueue.peekFirst();
    }

    // 入栈
    public void push_back(int value) {
        dataQueue.addLast(value);
        // 构建单调栈
        while (!decreseQueue.isEmpty() && decreseQueue.peekLast() < value) {
            decreseQueue.pollLast();
        }
        decreseQueue.addLast(value);
    }

    public int pop_front() {
        if (dataQueue.isEmpty()) return -1;
        int remove = dataQueue.pollFirst();
        if (decreseQueue.peekFirst() == remove) {
            decreseQueue.pollFirst();
        }
        return remove;
    }
}
