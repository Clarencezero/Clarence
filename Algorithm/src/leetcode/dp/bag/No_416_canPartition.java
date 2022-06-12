package leetcode.dp.bag;

public class No_416_canPartition {
    public static void main(String[] args) {
        No_416_canPartition go = new No_416_canPartition();
        int[] nums = {1,5,10,6};
        System.out.println(go.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        // dp[i][j] 表示前 i 个物品在满足背包重量 j 的前提下所得到的最大价值
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;

        int[][] dp = new int[nums.length + 1][target + 1];

        // 遍历行
        for (int i = 1; i <= nums.length; i++) {
            // 遍历列
            for (int j = 1; j <= target; j++) {
                System.out.print("(" + i + "," + j + "),");
                if (j < nums[i - 1]) continue;
                dp[i][j] = Math.max(dp[i - 1][j - nums[i - 1]] + nums[i - 1], dp[i - 1][j]);
            }
            System.out.println("");
        }

        printArr(dp);
        return true;
    }


    private void printArr(int[][] arr) {
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
