package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class No_216_combinationSum3 {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str.substring(0, 1));
        // No_216_combinationSum3 go = new No_216_combinationSum3();
        // List<List<Integer>> lists = go.combinationSum3(9, 45);
        // for (List<Integer> list : lists) {
        //     System.out.println(list);
        // }
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n <= 0) return res;
        backTracking(k, n, 1);
        return res;
    }

    private void backTracking(int k, int sum, int start) {
        if (sum < 0) return ;
        if (sum == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = start; i < 10; i++) {
            path.add(i);
            int target = sum - i;
            System.out.println(String.format("i: %s, target: %s, path: %s", i, target, path));
            backTracking(k, sum - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
