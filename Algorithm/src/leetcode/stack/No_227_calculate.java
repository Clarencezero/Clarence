package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No_227_calculate {
    public static void main(String[] args) {
        No_227_calculate go = new No_227_calculate();
        String s = "(3+2)*2";
        System.out.println(go.calculate(s));
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.replace(" ", ""); // 去除空格
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        char[] cs = s.toCharArray();
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast('(');
            } else if (c == ')') {
                // caculate
                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    cal(num, ops);
                }
                ops.pollLast();
            } else {
                if (isDigit(c)) {
                    int j = i, target = 0;
                    while (j < cs.length && isDigit(cs[j])) {
                        target = target * 10 + cs[j] - '0';
                        j++;
                    }
                    i = j - 1;
                    num.addLast(target);
                } else {
                    // 处理 (-4) 这样的情况
                    if (i > 0 && cs[i - 1] == '(') {
                        num.addLast(0); // 添加一个占位符
                    }
                    // 处理栈内优先级
                    while (!ops.isEmpty() && priority.get(ops.peekLast()) >= priority.get(c)) {
                        cal(num, ops);
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()) {
            cal(num, ops);
        }
        return num.pollLast();
    }

    private void cal(Deque<Integer> num, Deque<Character> ops) {
        int a = num.pollLast(), b = num.pollLast(), ans = 0;
        char op = ops.pollLast();
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = b - a;
        } else if (op == '*') {
            ans = b * a;
        } else if (op == '/') {
            ans = b / a;
        }
        num.addLast(ans);
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
