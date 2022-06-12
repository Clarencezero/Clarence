package leetcode.dp;

import java.util.Arrays;

public class No_279_numSquares {
    public static void main(String[] args) {
        No_279_numSquares go = new No_279_numSquares();
        System.out.println(go.numSquares(12));
    }

    public int numSquares(int n) {
        // 准备物品
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 遍历行，再遍历列
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n];
    }
}
