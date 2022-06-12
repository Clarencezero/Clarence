package leetcode.string;

public class KMP {
    // dp[j][c] = next：当前状态为 j，遇到字符 c pat 的转移状态是 next
    private int[][] dp;
    private String pat;
    public KMP(String pat) {
        this.pat = pat;
        int sLen = pat.length();
        dp = new int[sLen][256];

        // base case
        dp[0][pat.charAt(0)] = 1;

        int x = 0;

        // 构建状态转移图
        for (int j = 1; j < sLen; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[x][c];
            }
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影子状态：当前状态是 x，遇到字符 pat[j]，pat 应该转移到哪个状态
            x = dp[x][pat.charAt(j)];
        }
    }
}
