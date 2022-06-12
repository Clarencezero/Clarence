package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class No_42_trap {
    public static void main(String[] args) {
        No_42_trap go = new No_42_trap();
        // int[] h = {4,2,0,3,2,5};
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(go.trap(h));
    }

    public int trap(int[] height) {
        // 单调栈：单调递增还是单调递减呢?
        // 单调递减的栈
        if (height == null || height.length == 0) return 0;

        // 单调递减的栈
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i <= height.length - 1; i++) {

            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                int popIndex = stack.pollLast();
                // 计算区域面积
                if (!stack.isEmpty()) {
                    int width = i - stack.peekLast() - 1;
                    int hi = Math.min(height[i], height[stack.peekLast()]) - height[popIndex];
                    System.out.println(String.format("计算区间[%s,%s]的水域面积：%s", stack.peekLast(), i, (width * hi)));
                    result += width * hi;
                }
            }
            stack.addLast(i);
        }
        return result;
    }
}
