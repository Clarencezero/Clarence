package leetcode.prefixsub;

import java.util.HashMap;
import java.util.Map;

public class No_500_subarraySum {

    public static void main(String[] args) {
        No_500_subarraySum go = new No_500_subarraySum();
        int[] nums = {1, -1, 1};
        go.subarraySum(nums, 0);

    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int preSum = 0, valid = 0;
        for (int num : nums) {
            preSum += num;
            if (countMap.containsKey(preSum - k)) {
                valid += countMap.get(preSum - k);
            }
            // 这里是存储 k - preSum ?
            countMap.put(preSum, countMap.getOrDefault(preSum, 0) + 1);
        }
        return valid;
    }
}
