package leetcode.dp.bag;

import util.Util;

public class No_000_onezerobag {
    public static void main(String[] args) {
        int[] weight = {3, 2, 1};
        int[] val = {1, 2, 3};

        int bagWeight = weight.length;

        int[][] dp = new int[4][7];

        // init
        // for (int i = 0; i < 7; i++) {
        //     if (i >= weight[0]) {
        //         dp[0][i] = val[0];
        //     }
        // }

        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else { // i = 2, j = 2 dp[i - 1][j] = dp[1][2] = 2, dp[i - 1][j - w[i]] = dp[1][2-1] = 0 , 2 + val[2] = 5
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + val[i]);
                }
            }
        }
        Util.printTwoDimensionalArray(dp);
    }

}
