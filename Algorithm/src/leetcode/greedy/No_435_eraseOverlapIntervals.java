package leetcode.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No_435_eraseOverlapIntervals {
    public static void main(String[] args) {
        No_435_eraseOverlapIntervals go = new No_435_eraseOverlapIntervals();
        int[][] intervals = {{1, 2}, {2, 3}};
        int i = go.eraseOverlapIntervals(intervals);
        Set set = new HashSet();
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 移除区间的最小数量
        // 按右边界进行排序，从左往右遍历，因为右边界最小，留给其它区间可用范围越大
        // 按左边界进行排序，从右往左遍历，因为左边界最小，留给其它区间左边可用范围越大

        // 1. 排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(b[1], a[1]));

        // 2. 从左往右遍历
        int result = 1, prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 寻找下一个大小 prev 的区间
            if (intervals[i][0] > prev) {
                result++;
                prev = intervals[i][1];
            }
        }

        return result;

    }
}
