package jianzhioffer;

import java.util.*;

public class No_38_permutation {
    public static void main(String[] args) {
        No_38_permutation go = new No_38_permutation();
        String str = "abcc";
        String[] permutation = go.permutation(str);
        for (String s : permutation) {
            System.out.print(s + " ");
        }
    }

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];

        // 字符全排列
        // 回溯
        char[] chars = s.toCharArray();
        List<Character> path = new ArrayList<>();
        boolean[] visit = new boolean[chars.length];
        List<String> res = new ArrayList<>();
        Arrays.sort(chars);

        backTracking(chars, visit, path, res);

        String[] array = new String[res.size()];
        int i = 0;
        for (String str : res) {
            array[i++] = str;
        }

        return array;
    }

    private void backTracking(char[] chars,  boolean[] visit, List<Character> path, List<String> res) {
        if (path.size() == chars.length) {
            // 收集
            System.out.println(getStr(path));
            res.add(getStr(path));
            return ;
        }

        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1] && !visit[i - 1]) continue;
            if (visit[i]) continue;
            visit[i] = true;
            path.add(chars[i]);
            backTracking(chars, visit, path, res);
            path.remove(path.size() - 1);
            visit[i] = false;
        }
    }


    private String getStr(List<Character> path) {
        StringBuilder str = new StringBuilder();
        for (char c : path) {
            str.append(c);
        }

        return str.toString();
    }
}
