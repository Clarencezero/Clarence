package leetcode.heap;

import util.Util;

import java.util.PriorityQueue;

public class No_offer_40_getLeastNumbers {
    public static void main(String[] args) {
        No_offer_40_getLeastNumbers go = new No_offer_40_getLeastNumbers();
        int[] arr = {0,0,0,2,0,5};
        int k = 2;
        int[] result = go.getLeastNumbers(arr, k);
        Util.printArray(result);
        go.testPriority();
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        for (int i : arr) {
            if (queue.size() >= k) {
                if (queue.peek() > i) {
                    queue.add(i);
                    queue.poll();
                }
            } else {
                queue.add(i);
            }
        }
        int[] result = new int[k];
        int i = k - 1;
        while (!queue.isEmpty()) {
            result[i--] = queue.poll();
        }
        return result;
    }

    private void testPriority() {
        // 正序排序
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1, o2)));
        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
