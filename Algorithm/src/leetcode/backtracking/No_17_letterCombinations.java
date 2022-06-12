package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_17_letterCombinations {
    public static void main(String[] args) {
        No_17_letterCombinations go = new No_17_letterCombinations();
        List<String> list = go.letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }

    StringBuilder path = new StringBuilder();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> dict = new HashMap<>();
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");
        if (digits == null || digits.length() == 0) return res;
        backTracking(digits, 0, dict);
        return res;
    }

    // 根据叶子节点进行数据收集
    private void backTracking(String digits, int n, Map<Integer, String> dict) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        int k = digits.charAt(n) - '0';

        String letters = dict.get(k);
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));

            backTracking(digits, n + 1, dict);

            path.setLength(path.length() - 1);
        }
    }
}
