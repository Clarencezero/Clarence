package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No451SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println("hello");
//        String str = "abca";
//        String s = frequencySort(str);
//        System.out.println(s);
    }

    public static String frequencySort(String s) {
        // 1.先遍历至数组中
        int[] latters = new int[256];
        for (char c : s.toCharArray()) {
            latters[c]++;
        }

        // 2.将下标放入优先队列
        PriorityQueue<Integer> index = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return latters[o2] - latters[o1];
            }
        });
        for (int i = 0; i < latters.length; i++) {
            if (latters[i] != 0) {
                index.offer(i);
            }
        }

        //
        StringBuilder sb = new StringBuilder();
        while (!index.isEmpty()) {
            int poll = index.poll(); // char
                for (int i = 0; i < latters[poll]; i++) {
                    sb.append((char)poll);
            }
        }

        // 3.遍历优化队列拿东西

        return sb.toString();
    }


}
