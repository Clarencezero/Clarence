package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class No_93_restoreIpAddresses2 {

    public static void main(String[] args) {
        No_93_restoreIpAddresses2 go = new No_93_restoreIpAddresses2();
        List<String> list = go.restoreIpAddresses("1234");
        for (String s : list) {
            System.out.println(s);
        }

    }

    private List<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return res;

        // backTracking(s, 0, 0);
        // dfs(s, s.length(), 0, 0, "");
        backTracking(s, 0, 0);

        return res;
    }

    private void backTracking(String s, int startIndex, int dotNum) {
        if (dotNum > 4) return;
        if (startIndex == s.length() && dotNum == 4) {
            res.add(path.toString());
            return;
        }

        int pathLength = path.length();
        for (int i = startIndex; i < startIndex + 3; i++) {
            if (i >= s.length()) break;
            // 剪枝：剩余的数字个数不足以支撑剩余的ip段数


            System.out.println(String.format("Str range: [%s, %s]", startIndex, i + 1));
            String str = s.substring(startIndex, i + 1);
            if (s.charAt(startIndex) == '0' || Integer.parseInt(str) > 255) continue;
            path.append(str).append(".");
            backTracking(s, startIndex + 1, dotNum + 1);
            path.setLength(pathLength);
        }
    }

    private void backTracking2(String s, int startIndex, int dotNums) {
        if (dotNums == 4) {
            res.add(path.toString());
            return;
        }

        // 3 - dotNums：剩余IP段个数
        int endMinIndex = Math.max(startIndex + 1, (3 - dotNums) * 3);
        int endMaxIndex = Math.max(startIndex + 3, startIndex - (3 - dotNums));

        for (int i = endMinIndex; i <= endMaxIndex; i++) {
            // 第一个字符为0
            if (i > startIndex + 1 &&s.charAt(i) == '0') break;

            // 获取段
            String sub = s.substring(startIndex, i);
            // 超出255, 剪枝
            if (Integer.parseInt(sub) > 255) break;

            path.append(sub).append(".");
            backTracking(s, i, dotNums + 1);
            path.setLength(path.length() - 1);
        }
    }

    /**
     * @param start
     * @param depth 当前已经选出了几个 ip 段
     * @param path
     */
    private void dfs(String s, int n, int start, int depth, String path) {
        if (depth == 4) {
            res.add(path.substring(0, path.length() - 1));
            return;
        }

        // 3 - depth 表示剩余的 ip 段个数
        // n - (3 - depth) * 3 表示剩余的 ip 段如果都是 3 位数，当前 ip 段的结束位置（取不到）
        int endMin = Math.max(start + 1, n - (3 - depth) * 3);

        // n - (3 - depth) * 1 表示剩余的 ip 段如果都是 1 位数，当前 ip 段的结束位置（取不到）
        int endMax = Math.min(start + 3, n - (3 - depth));

        for (int i = endMin; i <= endMax; i++) {
            String split = s.substring(start, i);
            int len = split.length();

            if (len > 1 && split.charAt(0) == '0') {
                break;
            }

            if (Integer.parseInt(split) <= 255) {
                dfs(s, n, i, depth + 1, path + (split + '.'));
            }
        }
    }
}
