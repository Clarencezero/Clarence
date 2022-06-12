package leetcode.dp;

import util.Util;

import java.util.Arrays;

/**
 * LC 300 问题的这种：输出最长递增子序列，如果长度相同，返回字典序最小的递增子序列
 */
public class No_300_GetLIS {
    public static void main(String[] args) {
        No_300_GetLIS go = new No_300_GetLIS();
        // 最长递增子序列为：1, 2, 4, 5
        // DP：0 2 0 3 3 5
        int[] nums = {5,4,1,2,3};
        int[] lis = go.LIS(nums);
        Util.printArray(lis);
    }


    public int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] heap = new int[n];
        int piles = 0;
        for (int i : nums) {
            if (i > heap[piles] || piles == 0) {
                heap[++piles] = i;
            } else {
                // 使用二分查找搜索左边界，
                int left = 0, right = piles;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (i == heap[mid]) {
                        right = mid;
                    } else if (i > heap[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 更新 heap
                heap[left] = i;
            }
        }
        return piles;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // dp[i] 表示以 i 结尾的最长递增子序列长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i && nums[i] > nums[j]; j++) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }

    private int[] getLIS(int[] nums) {
        int len = nums.length;
        // dp[i]：存储位置 i 对应的最长子序列长度
        int[] dp = new int[len];

        // 存储长度为 i 时子序列的最后一个元素的最小值
        int[] end = new int[len + 1];

        // 初始化
        dp[0] = 1;
        end[1] = nums[0];

        int maxLength = 1;

        for (int i = 0; i < len; i++) {
            // if ()
        }
        return null;
    }

    public int[] LIS(int[] nums) {

        // 存储当前位置最长子序列长度
        int[] dp = new int[nums.length];

        // 存储最长子序列的数组，且是字典序的
        int[] end = new int[nums.length + 1];

        // 初始化
        dp[0] = 1;
        end[1] = nums[0];
        int len = 1;

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > end[len]) {
                // 如果递增则放入 end 数组中
                end[++len] = nums[i];
                // 长度 +1
                dp[i] = len;
            } else {
                // 否则在 end 中用二分查找寻找替换位置
                int left = 0;
                int right = len;
                int target = nums[i];
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (end[mid] == target) {
                        right = mid;
                    } else if (end[mid] > target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                end[left] = nums[i];
                // 更新长度
                dp[i] = left;
            }
        }
        Util.printArray(dp, "DP");
        Util.printArray(end, "END");

        // 字典序最小，如果 dp 中长度相同，那么在后面的那个肯定是小于前面的，所以从后往前查找
        int[] res = new int[len];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = nums[i];
            }
        }
        return res;

    }
}
