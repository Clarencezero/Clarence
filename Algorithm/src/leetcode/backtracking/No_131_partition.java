package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class No_131_partition {
    public static void main(String[] args) {
        No_131_partition go = new No_131_partition();
        List<List<String>> abc = go.partition("aab");
        for (List<String> list : abc) {
            System.out.println(list);
        }
    }

    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return res;
        backTracking(s, 0);
        return res;
    }


    private void backTracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            // 到了叶子节点，收集结果
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // System.out.println(String.format("i: %s, startIndex: %s", i, startIndex));
            System.out.println("区间:" + startIndex + ", " + i   + "  " + s.substring(startIndex, i + 1));
            if (isPalindrome(s, startIndex, i )) {
                // 加入path
                path.add(s.substring(startIndex, i  + 1));
            } else {
                continue;
            }

            backTracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }


    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++; end--;
        }
        return true;
    }
}
