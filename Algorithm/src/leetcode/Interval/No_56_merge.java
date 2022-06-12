package leetcode.Interval;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_56_merge {
    public static void main(String[] args) {
        No_56_merge go = new No_56_merge();
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = go.merge(arr);
        for (int[] ints : merge) {
            Util.printArray(ints);
        }
    }

    public int[][] merge(int[][] intervals) {
        // 1.二维数组排序，
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int index = 0;
        for(int i = 1; i < intervals.length; i++) {
            int[] list = result.get(index);
            int left = list[0], right = list[1];
            if (intervals[i][0] > right) {
                // 创建新的
                result.add(intervals[i]);
            } else {
                list[1] = Math.max(list[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
