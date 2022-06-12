package leetcode.dp;

public class No_416_canPartition {
    public static void main(String[] args) {
        No_416_canPartition go = new No_416_canPartition();
        int[] nums = {1,5,11,5};
        System.out.println(go.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        // dp[i][j]：横坐标表示总和，纵标示表示子集元素
        // dp[i][j]意味着凑成背包重量为i的最大价值
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 排队奇数
        if ((sum & 1) != 0) return false;
        int row = nums.length;
        int col = sum / 2  + 1;

        // 定义dp
        // dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i])
        int[][] dp = new int[row][col];

        // 初始化，第一行需要从后往前遍历
        for (int i = col - 1; i >= nums[0]; i--) {
            dp[0][i] = dp[0][i - nums[0]] + nums[0];
            System.out.println(String.format("maxValDp[0][%s]=%s", i, dp[0][i]));
        }

        // 构建dp数组
        for (int j = 0; j < col; j++) {            // 遍历背包容量（横坐标遍历）
            for (int i = 1; i < nums.length; i++) { // 遍历物品（纵坐标遍历）
                System.out.println(String.format("i: %s, j:%s, i-nums[j]: %s", j, i, (j - nums[i])));
                // 判断一下背包容量是否满足
                if (j < nums[i]) continue;
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
            }
        }


        return dp[row - 1][col - 1] == sum / 2;
    }
}
