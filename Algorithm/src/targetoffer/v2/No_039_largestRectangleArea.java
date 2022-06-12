package targetoffer.v2;

import java.util.ArrayDeque;
import java.util.Deque;

public class No_039_largestRectangleArea {
    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        No_039_largestRectangleArea go = new No_039_largestRectangleArea();
        System.out.println(go.largestRectangleArea(height));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int[] newH = new int[n + 2];
        System.arraycopy(heights, 0, newH, 1, n);
        n = n + 2;
        int maxArea = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < n; i++) {
            // 单调递增栈
            while (!stack.isEmpty() && newH[stack.peekLast()] > newH[i]) {
                int index = stack.pollLast();
                int height = Math.max(newH[stack.peekLast()], newH[i]);
                int width = i - stack.peekLast() - 1;
                maxArea = Math.max(height * width, maxArea);

                // int curHeight = heights[stack.pollLast()];
                // int curWidth = i - stack.peekLast() - 1;
                // res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        return maxArea;
    }
}
