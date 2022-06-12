package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_39_combinationSum {
    public static void main(String[] args) {
        No_39_combinationSum go = new No_39_combinationSum();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> lists = go.combinationSum(candidates, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;

        Arrays.sort(candidates);

        List<Integer> path = new ArrayList<>();
        backTracking(candidates, path, 0, target, res);
        return res;
    }

    private void backTracking(int[] candidates, List<Integer> path, int startIndex, int target, List<List<Integer>> res) {
        System.out.println(String.format("path: %s, startIndex: %s, target: %s", path, startIndex, target));
        if (target < 0 ) return;
        if (target == 0) {
            // 输出
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = startIndex; i < candidates.length ; i++) {
            System.out.println("for 循环: " + i);
            path.add(candidates[i]);
            backTracking(candidates, path, i, target - candidates[i], res);
            path.remove(path.size() - 1);
        }
    }
}
