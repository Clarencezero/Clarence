package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No_496_Next_greater_element_i {
    public static void main(String[] args) {
        // int[] n1 = {4,1,2};
        // int[] n2 = {1,3,4,2};
        // nextGreaterElement(n1, n2);
        int[] arr = new int[26];
        String str = "abcdefghigklms";
        for (char c : str.toCharArray()) {
            System.out.println((c-'a') % 26);
        }
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return nums1;
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        // 构造单调递减栈，当大于栈顶就弹出
        Deque<Integer> stack = new ArrayDeque<>();
        // 构造map
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peekLast()] < nums2[i]) {
                // 出栈
                int index = stack.pollLast();
                map.put(nums2[index], nums2[i]); // 最大值
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pollLast(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
