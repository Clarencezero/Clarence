package leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No_22_generateParenthesis {
    public static void main(String[] args) {
        No_22_generateParenthesis demo = new No_22_generateParenthesis();
        List<String> list = demo.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        if (n == 0) return res;
        helper(0, 0, n, path, res);
        return res;
    }

    private void helper(int left, int right, int n, List<Character> path, List<String> res) {

        if (left == n && right == n && isValid(path)) {
            StringBuffer str = new StringBuffer();
            for (Character character : path) {
                str.append(character);
            }
            res.add(str.toString());
        }

        if (left < n) {
            path.add('(');
            helper(left + 1, right, n, path, res);
            path.remove(path.size() - 1);
        }
        if (right < n) {
            path.add(')');
            helper(left, right + 1, n, path, res);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(List<Character> path) {
        if (path.get(0) != '(') return false;
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : path) {
            if (c == '(') {
                stack.addLast(')');
            } else if (!stack.isEmpty() && stack.peekLast() != ')') {
                return false;
            } else {
                stack.pollLast();
            }
        }

        return stack.isEmpty();
    }
}
