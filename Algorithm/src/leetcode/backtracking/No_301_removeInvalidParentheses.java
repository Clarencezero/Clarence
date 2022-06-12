package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_301_removeInvalidParentheses {
    public static void main(String[] args) {
        No_301_removeInvalidParentheses go = new No_301_removeInvalidParentheses();
        String str = ")(f";
        List<String> strings = go.removeInvalidParentheses(str);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    Set<String> res = new HashSet<>();
    int max;
    int maxLen = 0;
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                left ++;
            } else if (c == ')') {
                right ++;
            }
        }
        max = Math.min(left, right);
        // (：+1，)：-1
        StringBuilder sb = new StringBuilder();
        backTracking(chars, sb, 0, 0);
        return new ArrayList(res);
    }

    private void backTracking(char[] chars, StringBuilder temp, int index, int score) {
        // score < 0：())
        if (score < 0 || score > max) return;
        if (index >= chars.length) {
            // collect
            if (score == 0 && temp.length() >= maxLen) {
                System.out.println(score + " " + temp.toString());
                if (temp.length() > maxLen) res.clear();
                maxLen = temp.length();
                res.add(temp.toString());
            }
            return;
        }


        if (chars[index] == '(') {
            backTracking(chars, temp.append('('), index + 1, score + 1);
            temp.setLength(temp.length() - 1);

            backTracking(chars, temp, index + 1, score);
        } else if (chars[index] == ')') {

            backTracking(chars, temp.append(')'), index + 1, score - 1);
            temp.setLength(temp.length() - 1);

            backTracking(chars, temp, index + 1, score);
        } else {
            backTracking(chars, temp.append(chars[index]), index + 1, score);
            temp.setLength(temp.length() - 1);
        }
    }
}
