package leetcode.priorityqueue;

import util.Util;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * https://www.nowcoder.com/questionTerminal/7201cacf73e7495aa5f88b223bbbf6d1
 * 给定两个有序数组 arr1 arr2，再给定一个k，返回 arr1 和 arr2 的两个数相加和最大的前 k 个
 */
class Node implements Comparable<Node> {
    public int i;
    public int j;
    public int val;

    public Node(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(o.val, this.val);
    }
}

public class NC_Two_array_topK {
    public static void main(String[] args) {
        NC_Two_array_topK go = new NC_Two_array_topK();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 5, 7, 9, 11};
        int k = 4;
        // 结果：16 15 14 14
        int[] res = go.topK(arr1, arr2, k);
        Util.printArray(res);
    }

    /**
     * 1. 创建一个优先队列
     * 2. 将最后两个数组放到队列中
     * 3. 使用 HashSet<String> 去重
     */
    private static int[] topK(int[] arr1, int[] arr2, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int i = arr1.length - 1, j = arr2.length - 1;
        queue.add(new Node(i, j, arr1[i] + arr2[j]));
        HashSet<String> set = new HashSet<>();
        set.add(getStr(i, j));
        int[] res = new int[k];
        int index = 0;
        while (index < k) {
            // 4.从队列中获取最大值
            Node node = queue.poll();

            // 5.记录最大值
            res[index++] = node.val;

            // 6.BFS体现
            i = node.i;
            j = node.j;
            if (i - 1 >= 0 && !set.contains(getStr(i - 1, j))) {
                set.add(getStr(i - 1, j));
                queue.add(new Node(i - 1, j, arr1[i - 1] + arr2[j]));
            }

            if (j - 1 >= 0 && !set.contains(getStr(i, j - 1))) {
                set.add(getStr(i, j - 1));
                queue.add(new Node(i, j - 1, arr1[i] + arr2[j - 1]));
            }
        }
        return res;
    }

    private static String getStr(int i, int j) {
        return i + "_" + j;
    }
}













