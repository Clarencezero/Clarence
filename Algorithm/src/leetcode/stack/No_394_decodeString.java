package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class No_394_decodeString {
    public static void main(String[] args) {
        No_394_decodeString go = new No_394_decodeString();
        String s1 = "3[a]2[bc]";
        System.out.println(go.decodeString2(s1));
    }

    public String decodeString2(String s) {
        if (s == null || s.length() == 0) return "";
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            queue.addLast(c);
        }

        return helper(queue);
    }

    private String helper(Deque<Character> queue) {
        StringBuilder cur = new StringBuilder();
        int cnt = 0;
        while (!queue.isEmpty()) {
            char c = queue.pollFirst();
            if (Character.isDigit(c)) {
                // 如果是数字，记录当前层的数字
                cnt = cnt * 10 + c - '0';
            } else if (c == '[') {
                // 说明需要递归下一层
                String sub = helper(queue);
                while (cnt > 0) {
                    cur.append(sub);
                }
            } else if (c == ']') {
                break;
            } else {
                cur.append(c);
            }
        }

        return cur.toString();
    }

    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Deque<Integer> kStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();

        StringBuilder res = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 如果是数字，则累加
                k = k * 10 + c - '0';
            } else if (c == '[') {
                // 如果是这个[，说明需要将当前层保存起来
                strStack.addLast(res);
                kStack.addLast(k);
                k = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 说明需要出栈了
                int nums = kStack.pollLast();
                StringBuilder cur = res;
                res = strStack.pollLast();
                for (int i = 0; i < nums; i++) {
                    res.append(cur);
                }
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
