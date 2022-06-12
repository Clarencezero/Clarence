package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 拿排序后的第K小元素:
 */
public class No378KthSmallestElementinaSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int i = kthSmallest(matrix, 2);
        System.out.println(i);
    }

    // method 1 遍历-最小堆
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; ++j) {
                queue.add(matrix[i][j]);
                if (queue.size() > matrix.length * matrix.length - k + 1) {
                    Integer poll = queue.poll();
                }
            }
        }

        return queue.poll();
    }
}
