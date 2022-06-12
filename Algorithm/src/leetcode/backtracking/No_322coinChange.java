package leetcode.backtracking;

import util.Util;

import java.util.Arrays;

public class No_322coinChange {
    public static void main(String[] args) {
        No_322coinChange go = new No_322coinChange();
        int[] coins = {1,2,5};
        System.out.println(go.coinChange3(coins, 6));
        System.out.println(go.coinChange2(coins, 6));
    }

    public int coinChange3(int[] coins, int amount) {
        // dp[i]：表示构建i所需最少的硬币数量
        if (coins == null || coins.length == 0 || amount == 0) return 0;

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int corn = 0; corn < coins.length; corn++) {
                // 更新dp[i] = Math.min(dp[i], dp[i - corn] + 1)
                if (i >= coins[corn] && dp[i - coins[corn]] != Integer.MAX_VALUE) {
                    //  System.out.println(" " + (i - coins[corn]) + " " + i + "  " + coins[corn]);

                    dp[i] = Math.min(dp[i], dp[i - coins[corn]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // 动态规划一：这么写是可以的，但是对于 [2] 3 这种情况会返回错误
    // 这是初始值导致的问题
    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) return 0;
        // 动态规划
        // dp[i]：表示组成目标数i所需要最小硬币数
        // 递推方程 dp[i] = Math.min((i - corns) corns∈(1,2,5)) n > 0
        // dp[i] = Math.min(dp[i - corn] + 1, dp[i]);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 初始化

        // 从0到1开始构建
        for (int i = 1; i <= amount; i++) {
            // 完全背包，里面再包含一层for循环从数组中获取
            for (int corn = 0; corn < coins.length; corn++) {
                if (i - coins[corn] >= 0) {
                    System.out.println(String.format("获取目标值：%s", i - coins[corn]));
                    dp[i] = Math.min(dp[i], dp[i - coins[corn]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    // 递归+回溯
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) return 0;

        // 记录目标整数amount所需要最小的硬币数量
        int[] memory = new int[amount + 1];
        helper(coins, amount, memory);

        return memory[amount];
    }

    // 返回值表示 amount 最少花费硬币数量
    // 规定：1.当遇到无解情况，返回-1
    // memory[amount]:表示钱币可以被换取的最小硬币数，不能换取就为-1
    private int helper(int[] coins, int amount, int[] memory) {
        if (amount < 0) return -1;
        if (memory[amount] != 0) return memory[amount];

        // 当amount==0时，这是是返回0的，而不是1
        if (amount == 0) return 0;

        // 我需要分别比较使用1, 2, 5 这三种硬币各自所需要的最小值
        // 然后从里面得到当前amount的最小值
        int minCount = Integer.MAX_VALUE;
        for (int coin = 0; coin < coins.length; coin++) {
            int target = amount - coins[coin];
            int minTarget = helper(coins, target, memory);
            // 这里直接加1会有问题，因为会返回-1
            // 而且这里判断时会带上0，不然不会进去
            // 这里就是相当于是Math.min()取得每次比较的最小值即可
            if (minTarget >= 0 && minTarget < minCount) {
                minCount = minTarget + 1;
            }
        }

        memory[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        Util.printArray(memory);
        return minCount;
    }

}
