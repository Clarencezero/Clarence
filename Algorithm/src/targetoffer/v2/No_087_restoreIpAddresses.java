package targetoffer.v2;

import java.util.ArrayList;
import java.util.List;

public class No_087_restoreIpAddresses {
    public static void main(String[] args) {
        No_087_restoreIpAddresses go = new No_087_restoreIpAddresses();
        String str = "25525511135";
        List<String> strings = go.restoreIpAddresses(str);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backTracking(s, 0, 0, path);
        return res;
    }

    private void backTracking(String s, int pos, int dot, StringBuilder path) {
        // System.out.println(String.format("dot: %s, pos: %s", dot, pos));
        if (dot == 3) {
            // 收集
            // 判断第四段是否合法
            String sub = s.substring(pos, s.length());
            if (isValid(sub)) {
                res.add(path.substring(0, path.length() - 1));
            }
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            String sub = s.substring(pos, i + 1);
            if (!isValid(sub)) break;
            path.append(sub).append(".");
            backTracking(s, i + 1, dot + 1, path);
            path.setLength(path.length() - 1 - sub.length());
        }
    }

    private boolean isValid(String s) {
        // 首位 0
        int len = s.length();
        if (s.charAt(0) == '0' && len > 1 ) return false;
        if (len > 3) return false;
        if (Integer.parseInt(s) > 255) return false;
        return true;
    }
}
