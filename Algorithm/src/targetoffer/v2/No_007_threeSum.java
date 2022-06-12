package targetoffer.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_007_threeSum {
    public static void main(String[] args) {
        No_007_threeSum go = new No_007_threeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = go.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 三数之和可以化为求两数之和
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 求两数之和
            int target = -nums[i];
            List<List<Integer>> list = twoSum(nums, i + 1, nums.length - 1, target);
            if (list.size() > 0) {
                // collect
                for (List<Integer> li : list) {
                    li.add(0, nums[i]);
                    res.add(li);
                }
            }
        }
        return res;
    }


    private List<List<Integer>> twoSum(int[] nums, int lo, int hi, int target) {
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                // collect
                List<Integer> list = new ArrayList<>();
                list.add(nums[lo]);
                list.add(nums[hi]);
                res.add(list);
                lo++;
                hi--;
            } else if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return res;
    }

}
