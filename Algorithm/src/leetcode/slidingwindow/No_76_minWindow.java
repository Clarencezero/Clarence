package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class No_76_minWindow {
    public static void main(String[] args) {
        No_76_minWindow go = new No_76_minWindow();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        go.minWindow(s, t);
    }

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char add = s.charAt(right);
            System.out.println("add: " + add);
            right++;
            if (need.containsKey(add)) {
                int count = windows.getOrDefault(add, 0) + 1;
                if (need.get(add).equals(count)) {
                    // 如果相等，合法值+1
                    valid++;
                }
                windows.put(add, count);
            }
            System.out.println(String.format("窗口: [%s, %s), valid: %s. len: %s", left, right, valid, len));

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char remove = s.charAt(left);
                left++;
                if (need.containsKey(remove)) {
                    int count = windows.get(remove);
                    if (need.get(remove).equals(count)) {
                        valid--;
                    }
                    windows.put(remove, count - 1);
                }
            }
        }
        System.out.println(String.format("Start: %s, len: %s", start, len));
        return s.substring(start, start + len);

    }



}
