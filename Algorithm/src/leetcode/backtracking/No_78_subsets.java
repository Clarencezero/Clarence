package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class No_78_subsets {
    public static void main(String[] args) {
        No_78_subsets m = new No_78_subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = m.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return res;
        preOrder(nums, 0, list, res );
        return res;
    }

    private void preOrder(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        // #1 终止条件
        if (index == nums.length) {
            // 将路径加入结果集合中
            res.add(new ArrayList<>(list));
            return ;
        }

        preOrder(nums, index + 1, list, res);
        list.add(nums[index]);
        preOrder(nums, index + 1, list, res);
        list.remove(list.size() - 1); // 回溯
    }

}
