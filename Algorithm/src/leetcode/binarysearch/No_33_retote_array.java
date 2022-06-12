package leetcode.binarysearch;

import util.Util;

public class No_33_retote_array {
    public static void main(String[] args) {
        No_33_retote_array go = new No_33_retote_array();
        int[] nums = {3, 1, 2};
        Util.printArray(nums);
        System.out.println(go.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        // 当前区间长度为 1，说明已经可以结束二分查找，找到最小值了
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 目标是找最小值，最重要是确定mid在左半区还是在右半区
            System.out.println(String.format("搜索区间: [%s, %s], mid: %s", left, right, mid));
            if (nums[mid] > nums[right]) {
                // 说明左半区是单调增，那最小值应该出现在右半区
                // 这个成立条件是没有重复的元素
                left = mid + 1;
            } else {
                // 这里不能草率使用 mid - 1，否则就会错过最小值
                right = mid;
            }
        }
        // 退出while条件是 left == right
        return nums[left];
    }
}
