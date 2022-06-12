package targetoffer.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_082_combinationSum2 {
    public static void main(String[] args) {
        No_082_combinationSum2 go = new No_082_combinationSum2();
        int[] nums = {1, 1, 2};
        int target = 3;
        List<List<Integer>> lists = go.combinationSum2(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 1) return new ArrayList<>();
        res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        List<Integer> path = new ArrayList<>();
        backTracking(candidates, 0, target, path, visited);
        return res;
    }

    private void backTracking(int[] nums, int pos, int target, List<Integer> path, boolean[] visited) {
        if (target < 0) return;
        if (target == 0) {
            // collect
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            System.out.println(getBlackSpace(pos) + "当前节点: " + nums[i]);
            // if (i > 0 && !visited[i - 1] && nums[i - 1] == nums[i]) continue;
            path.add(nums[i]);
            visited[i] = true;
            // 剪枝
            backTracking(nums, i + 1, target - nums[i], path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    private String getBlackSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
