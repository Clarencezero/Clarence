package leetcode.dp.bag;

import util.Util;

/**
 * 完全背包模板代码
 */
public class No_001_allbag {
    public static void main(String[] args) {
        int[] weight = {1, 2, 5};
        int[] val = {1, 2, 5};

        int len = weight.length;

        int bag = 11;
        // for (int w : weight) {
        //     bag += w;
        // }

        int[][] dp = new int[len + 1][bag + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= bag; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - weight[i - 1]] + val[i - 1]);
                }
            }
        }
        Util.printTwoDimensionalArray(dp);

    }


}
