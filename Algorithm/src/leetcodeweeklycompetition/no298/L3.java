package leetcodeweeklycompetition.no298;

import util.Util;

public class L3 {
    public static void main(String[] args) {
        L3 go = new L3();
        String s = "1001010";
        int k = 5;
        System.out.println(go.longestSubsequence(s, k)); // 5
        System.out.println(Integer.parseInt("10", 2));
    }

    public int longestSubsequence(String s, int k) {
        int len = s.length();
        int[] lenSize = new int[len + 1];
        lenSize[0] = 1;
        lenSize[1] = 1;
        int[] sum = new int[len + 1];
        sum[1] = s.charAt(0) - '0';
        int result = 0;
        // dp[i] 表示以 i 结尾的最长子序列长度
        // dp[i+1] = for (0~i) + i
        for (int i = 1; i <= len; i++) {
            int maxLen = 1;
            for (int j = 1; j < i; j++) {
                int temp = s.charAt(i - 1) == '0' ? sum[j] * 2 : sum[j] * 2 + 1;
                if (temp <= k) {
                    if (lenSize[j] + 1 > maxLen) {
                        // 更新
                        maxLen = lenSize[j] + 1;
                        sum[i] = temp;
                    }
                }
            }
            lenSize[i] = maxLen;
            result = Math.max(result, maxLen);
        }
        System.out.println("len size:");
        Util.printArray(lenSize);
        System.out.println("sum: ");
        Util.printArray(sum);
        return result;
    }

    private int cal(String s) {
        return Integer.parseInt(s, 2);
    }
}
