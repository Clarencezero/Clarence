package leetcode.dp;

public class No_1143_longestCommonSubsequence {
    public static void main(String[] args) {
        No_1143_longestCommonSubsequence go = new No_1143_longestCommonSubsequence();
        System.out.println(go.longestCommonSubsequence("abcde", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int row = text2.length();
        int col = text1.length();

        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= row; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 两个字符相等，获取(i-1)和(j-1)的值+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                System.out.print(String.format("%s ", dp[i][j]));
            }
            System.out.println(" ");
        }

        return dp[row][col];
    }
}
