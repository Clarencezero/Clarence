package leetcode.backtracking;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class No_131_partition_2 {
    static List<List<String>> res = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        No_131_partition_2 go = new No_131_partition_2();
        String s = "abcd";
        List<String> path = new ArrayList<>();
        go.back(s, 0, path);
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        // 1.
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = n ; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        Util.printTwoDimensionalArray(dp);

        // 2.dfs 截取
        List<String> path = new ArrayList<>();
        // 索引位置从 1 开始
        backTracking(s, 1, path, dp);
        return res;
    }

    /**
     * 对 [startIndex, s.length()] 区间字符串进行回文子串判断，并不断进行分割处理
     */
    private void backTracking(String s, int startIndex, List<String> path, boolean[][] dp) {
        System.out.println("startIndex: " + startIndex);
        if (startIndex > s.length()) return;
        if (startIndex == s.length()) {
            // 收集
            List<String> l = new ArrayList<>(path);
            l.add(s.substring(startIndex - 1));
            res.add(l);
            return;
        }

        // 不断切割
        for (int i = startIndex; i < s.length(); i++) {
            System.out.println(String.format("区间[%s, %s)", startIndex - 1, i));
            // 不断截取并判断，字符串范围 [startIndex, i)
            if (dp[startIndex][i]) {
                // 截取字符串
                path.add(s.substring(startIndex - 1, i));
                backTracking(s, i + 1, path, dp);
                path.remove(path.size() - 1);
            }
        }
    }

    // 输出所有字符串分割路径
    private void back(String s, int start, List<String> path) {
        if (start > s.length()) return;
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            Util.printIndent(count++);
            System.out.println(String.format("区间: (%s, %s)", start, i));
            // path.add(s.substring(start, i + 1));
            back(s, i + 1, path);
            // path.remove(path.size() - 1);

            Util.printIndent(count--);
        }
    }
}
