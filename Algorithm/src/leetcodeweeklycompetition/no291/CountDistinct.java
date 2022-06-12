package leetcodeweeklycompetition.no291;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDistinct {
    public static void main(String[] args) {
        CountDistinct go = new CountDistinct();
        int[] nums = {2,3,3,2,2};
        go.countDistinct(nums, 2, 2);
    }

    List<List<Integer>> res = new ArrayList<>();
    public int countDistinct(int[] nums, int k, int p) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0,  path);
        for (List<Integer> r : res) {
            System.out.println(r);
        }
        return 0;
    }

    private void dfs(int[] nums, int start, List<Integer> path) {
        if (start > nums.length) {
            return;
        }
        if (start == nums.length) {
            // 判断数组是否超出个数
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
