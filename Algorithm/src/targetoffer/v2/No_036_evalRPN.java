package targetoffer.v2;

import java.util.ArrayDeque;
import java.util.Deque;

public class No_036_evalRPN {
    public static void main(String[] args) {
        String[] token = {"4", "13", "5", "/", "+"};
        No_036_evalRPN go = new No_036_evalRPN();
        System.out.println(go.evalRPN(token));
    }
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                int a = stack.pollLast();
                int b = stack.pollLast();
                stack.addLast(a + b);
            } else if (s.equals("-")) {
                int a = stack.pollLast();
                int b = stack.pollLast();
                stack.addLast(a - b);
            } else if (s.equals("*")) {
                int a = stack.pollLast();
                int b = stack.pollLast();
                stack.addLast(a * b);
            } else if (s.equals("/")) {
                int a = stack.pollLast();
                int b = stack.pollLast();
                stack.addLast(a / b);
            } else {
                stack.addLast(Integer.parseInt(s));
            }
        }
        return stack.pollLast();
    }
}
