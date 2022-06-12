package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class No_343_integerBreak2 {
    public static void main(String[] args) {
        No_343_integerBreak2 go = new No_343_integerBreak2();
        System.out.println(go.integerBreak(2));
    }

    private int maxRes = 0;
    private int n;

    public int integerBreak(int n) {
        if (n == 1) return 1;
        this.n = n;
        backtrack(n, new ArrayList<>());
        return maxRes;
    }

    private void backtrack(int remains, List<Integer> path) {
        if (remains < 0) return;
        if (remains == 0) {
            System.out.println(path);
            int count = 1;
            for (Integer i : path)
                count *= i;
            maxRes = Math.max(maxRes, count);
            return;
        }

        for (int i = 1; i < n; i++) {
            if (i > remains) continue;

            path.add(i);
            backtrack(remains - i, path);
            path.remove(path.size() - 1);
        }
    }
}
