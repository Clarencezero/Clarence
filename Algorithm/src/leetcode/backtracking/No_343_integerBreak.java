package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class No_343_integerBreak {
    public static void main(String[] args) {
        No_343_integerBreak go = new No_343_integerBreak();
        int i = go.integerBreak(2);
        System.out.println(i);
    }

    private int result = Integer.MIN_VALUE;
    public int integerBreak(int n) {
        if (n == 0) return 0;
        List<Integer> path = new ArrayList<>();
        backTracking(n, n , path);
        return result;
    }

    /**
     *
     * @param n         固定的值
     * @param remain    剩余值
     * @param path      路径
     */
    private void backTracking(int n, int remain, List<Integer> path) {
        if (remain < 0) return;
        if (remain == 0) {
            System.out.println(path);
            int count = 1;
            for (int i : path) {
                count *= i;
            }
            result = Math.max(result, count);
            return ;
        }

        for (int i = 1; i <= remain; i++) {
            // if (i > remain) continue;
            path.add(i);
            backTracking(n, remain - i, path);
            path.remove(path.size() - 1);
        }
    }
}
