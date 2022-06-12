package leetcode.backtracking;

import java.util.*;

public class No_77_combine {
    public static void main(String[] args) {
        No_77_combine go = new No_77_combine();
        List<List<Integer>> combine = go.combine(4, 2);
        // for (List<Integer> integers : combine) {
        //     System.out.println(integers);
        // }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        if ( n < 0 || k < 0) return res;
        backtracking(n, k, 1, path, res, 0);
        return res;
    }


    private void backtracking(int n, int k, int startIndex,  List<Integer> path , List<List<Integer>> res, int level) {
        if (startIndex > n) return;

        // 终止条件
        if (path.size() == k) {
            // System.out.println();
            res.add(new ArrayList<>(path));
            // return;
        }

        // 1()
        for (int i = startIndex; i <= n; i++) {
            System.out.println(String.format("i: %s, startIndex: %s, path: %s, level: %s", i, startIndex, path, level));
            path.add(i);
            // i+1
            backtracking(n, k, i + 1, path, res, level + 1);
            path.remove(path.size() - 1);
        }
    }
}
