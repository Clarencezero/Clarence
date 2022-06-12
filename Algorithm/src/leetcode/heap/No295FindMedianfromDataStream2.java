package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder2 {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    private boolean even = true;
    public MedianFinder2() {
        small = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        large = new PriorityQueue<>((o1, o2) -> o2-o1);
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (large.peek() + small.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}

public class No295FindMedianfromDataStream2 {
    public static void main(String[] args) {
        MedianFinder2 obj = new MedianFinder2();
        obj.addNum(2);
        obj.addNum(2);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }
}
