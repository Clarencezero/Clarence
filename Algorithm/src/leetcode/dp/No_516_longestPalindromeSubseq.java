package leetcode.dp;

import util.Util;

public class No_516_longestPalindromeSubseq {
    public static void main(String[] args) {
        No_516_longestPalindromeSubseq go = new No_516_longestPalindromeSubseq();
        System.out.println(go.longestPalindromeSubseq("cbbd"));
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null) return 0;
        int len = s.length();

        // dp[i][j] 表示字符串s[i][j]所能构造的子序列的最大长度
        int[][] dp = new int[len][len];

        // base case
        for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
        }

        // 从底向上遍历
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                System.out.println(String.format("区间: [%s, %s]", i, j));
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        Util.printTwoDimensionalArray(dp);

        return dp[0][len - 1];

    }
}
