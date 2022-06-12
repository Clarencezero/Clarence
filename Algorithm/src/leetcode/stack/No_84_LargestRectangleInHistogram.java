package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class No_84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {2, 4};
        // largestRectangleArea(arr);
        No_84_LargestRectangleInHistogram go = new No_84_LargestRectangleInHistogram();
        System.out.println(go.largestRectangleArea2(arr));
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int len = heights.length;
        int[] newHeight = new int[len + 2];
        System.arraycopy(heights, 0, newHeight, 1, len);
        int maxArena = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (newHeight[stack.peekLast()] > newHeight[i]) {
                // 计算前一个最大面积
                int curH = newHeight[stack.pollLast()];
                int curW = i - stack.peekLast() - 1;
                maxArena = Math.max(maxArena, curH * curW);

            }
            stack.addLast(i);

        }

        return maxArena;
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        int left, right;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            // 确定左指针
            left = i;
            right = i;
            while (left > 0 && heights[--left] >= heights[i]) {
            }
            // 确定右指针
            while (right < heights.length - 1 && heights[++right] >= heights[i]) {
                // right++;
            }

            // 计算面积
            maxArea = Math.max(maxArea, (right - left - 1) * heights[i]);
        }

        return maxArea;
    }
}
