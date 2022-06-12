package leetcode.binarysearch;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class No_658_findClosestElements {
    public static void main(String[] args) {
        No_658_findClosestElements go = new No_658_findClosestElements();
        int[] nums = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        Util.printArray(nums);
        List<Integer> closestElements = go.findClosestElements(nums, 3, 5);
        for (Integer closestElement : closestElements) {
            System.out.print(closestElement + " ");
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        // 左闭右开区间
        int left = 0;
        int right = size - k;

        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println(String.format("区间: [%s, %s], mid: %s", left, right, mid));

            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public List<Integer> findClosestElements2(int[] nums, int k, int x) {
        if (nums.length == 0) return new ArrayList<>();
        int len = nums.length;
        int leftBound = getLeftBound(nums, x);
        System.out.println("leftBound: " + leftBound + ",target: " + nums[leftBound]);
        // 闭区间
        int start = 0, end = 0;
        // 考虑第一种情况，leftBound = 0
        if (leftBound == 0) {
            end = k - 1;
        } else if (leftBound >= nums.length - 1) {
            end = nums.length - 1;
            start = nums.length - k;
        } else {
            // 从中间向两边散开取k个元素
            start = leftBound;
            end = leftBound;
            while (end - start + 1 < k) {
                if (start < 0) {
                    end++;
                    continue;
                }
                if (end >= len - 1) {
                    start--;
                    continue;
                }

                // System.out.println(String.format("区间: [%s, %s], 区内元素个数: %s, k: %s", start, end, end - start + 1, k));
                System.out.println(String.format("比较距离，左距离: %s, 右距离: %s", x - nums[start], nums[end] - x));
                if (x - nums[start] <= nums[end] - x) {
                    start--;
                } else {
                    end++;
                }
            }
        }

        // System.out.println(String.format("区间: [%s, %s], 区内元素个数: %s, k: %s", start, end, end - start + 1, k));

        List<Integer> res = new ArrayList<>();
        while (start <= end) {
            res.add(nums[start]);
            start++;
        }
        return res;
    }

    // 存在右边越界的情况
    private int getLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println(String.format("区间: [%s, %s], mid: %s", left, right, mid));
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        // 找到确定值
        if (nums[left] == target || left == 0 || left == nums.length) return left;

        // 确定上边界 还是下边界
        if (target - nums[left - 1] > nums[left] - target) {
            return left;
        } else {
            return left - 1;
        }
    }
}
