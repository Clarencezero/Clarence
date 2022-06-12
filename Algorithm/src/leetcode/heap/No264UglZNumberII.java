package leetcode.heap;

import java.util.*;

public class No264UglZNumberII {
    public static void main(String[] args) {
        // List<Integer> integers = nthUglyNumber(10);
        // integers.forEach(System.out::println);
        // long i = nthUglyNumber2(1407);
        // System.out.println(i);
        int i = nthUglyNumber3(10);
        System.out.println(i);
    }

    // 动态规划。用指针保持最小三位数?
    // 1.写出推导式 a[i] = Math.min(a[i-1]*2, a[i-1]*3,a[i-1]*5)
    public static int nthUglyNumber3(int n) {
        int[] res = new int[n];
        int p2 = 0, p3 = 0, p5 = 0, temp = 0;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            temp = Math.min(Math.min(res[p2] * 2, res[p3] * 3), res[p5] * 5);
            if (temp == res[p2] * 2) {
                p2++;
            }
            if (temp == res[p3] * 3) {
                p3++;
            }
            if (temp == res[p5] * 5) {
                p5++;
            }
            res[i] = temp;
        }

        return res[n-1];
    }

    public static int nthUglyNumber2(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> integerSet = new HashSet<>();
        long[] prims = {2, 3, 5};
        for (long prim : prims) {
            queue.offer(prim);
            integerSet.add(prim);
        }
        integerSet.add(1L);
        long k = 1;
        for (int j = 1; j < n; j++) {
            if (!queue.isEmpty()) {
                long poll = queue.poll();
                for (int i = 0; i < prims.length; i++) {
                    long target = prims[i] * poll;
                    if (!integerSet.contains(target)) {
                        queue.offer(target);
                        integerSet.add(target);
                    }
                }
                k = poll;
            }
        }
        return (int) k;
    }

    public static List<Integer> nthUglyNumber(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> resList = new ArrayList<>(n);
        Set<Integer> integerSet = new HashSet<>();
        int[] prims = {2, 3, 5};
        for (int prim : prims) {
            queue.offer(prim);
            integerSet.add(prim);
        }
        resList.add(1);
        integerSet.add(1);
        while (resList.size() <= n) {
            if (!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (int i = 0; i < prims.length; i++) {
                    int target = prims[i] * poll;
                    if (!integerSet.contains(target)) {
                        queue.offer(target);
                        integerSet.add(target);
                    }
                }
                resList.add(poll);
            }
        }
        return resList;
    }
}
