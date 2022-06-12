package leetcode.twopointer;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_15_threeSum {
    public static void main(String[] args) {
        No_15_threeSum go = new No_15_threeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = go.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        Util.printArray(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> curResult = twoSumTarget(nums, i + 1, -nums[i]);
            for (List<Integer> list : curResult) list.add(0, nums[i]);
            res.addAll(curResult);
        }
        return res;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum > target) hi--;
            else if (sum < target) lo++;
            else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[lo]);
                list.add(nums[hi]);
                result.add(list);
                while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                lo++;
                hi--;
            }
        }

        return result;
    }
}
