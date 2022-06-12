package leetcode.dp;

import static util.Util.printArray;

public class No_413_numberOfArithmeticSlices {
    public static void main(String[] args) {
        No_413_numberOfArithmeticSlices go = new No_413_numberOfArithmeticSlices();
        int[] nums = {1,2,3,4};
        System.out.println(go.numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        //
        int n = nums.length;

        // dp[i] 表示长度为[0 ~ i]的个数的子数组共有多少个
        int[] dp = new int[n];

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        printArray(dp);

        return dp[n - 1];
    }
}
