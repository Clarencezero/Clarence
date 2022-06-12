package leetcode.dp.bag;

import java.util.*;

public class No_139_wordBreak {
    public static void main(String[] args) {
        No_139_wordBreak go = new No_139_wordBreak();
        String s = "aaaaaaaaaaaaa";
        List<String> dict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa");
        System.out.println(go.wordBreak(s, dict));
        PriorityQueue queue = new PriorityQueue(1);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Set<String> dict = new HashSet(wordDict);

        int len = s.length();

        byte[] memo = new byte[len + 1];

        boolean result = backTrack(s, len, 0, dict, memo);

        // print(memo);

        return result;
    }

    // 回溯方法表示：从 start 到末尾是否能分割
    private boolean backTrack(String s, int len, int start, Set<String> dict, byte[] memo) {
        // 边界判断：走到字符串末尾了，那就说明前面一步一步进行划分才能走到这里
        if (start == len) return true;
        if (memo[start] != 0) return memo[start] != -1;
        for (int i = start + 1; i <= len; i++) {
            // [)
            String sub = s.substring(start, i);
            System.out.println("sub: " + sub + ", other: " + s.substring(i, len));
            if (dict.contains(sub) && backTrack(s, len, i, dict, memo)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = -1;
        print(memo);
        return false;
    }

    private void print(byte[] memo) {
        for (byte i : memo) {
            System.out.print(i + " ");
        }
    }
}
