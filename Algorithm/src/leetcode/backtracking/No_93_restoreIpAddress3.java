package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_93_restoreIpAddress3 {
    public static void main(String[] args) {
        No_93_restoreIpAddress3 go = new No_93_restoreIpAddress3();
        List<String> list = go.restoreIpAddresses("25525511135");
        for (String s : list) {
            System.out.println(s);
        }

    }
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return res;
        backTracking(s, 0, 0);
        return res;
    }

    private void backTracking(String s, int startIndex, int dotNum) {
        if (dotNum > 4) return;
        if (startIndex == s.length()) {
            if (dotNum == 4) {
                path.setLength(path.length() - 1);
                res.add(path.toString());
            }
            return ;
        }
        int pathLength = path.length();

        for (int i = startIndex; i < startIndex + 3; i++) {
            if (i >= s.length()) break;
            String str = s.substring(startIndex, i + 1);
            // 对0进行特判断
            if (isValid(str) || (s.charAt(startIndex) == '0' && i == startIndex)) {
                path.append(str).append(".");
                backTracking(s, i + 1, dotNum + 1);
                path.setLength(pathLength);
            } else {
                continue;
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        return Integer.parseInt(s) < 256;
    }
}
