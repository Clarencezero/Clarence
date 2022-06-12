package jianzhioffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No_03_Repeat_Number_In_Array {
    public static void main(String[] args) {
        int[] target = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] target2 = {2, 3, 1, 0, 2, 5, 3};
        // System.out.println(findRepeatNumber_1(target));
        // System.out.println(findRepeatNumber_2(target));
        System.out.println(findRepeatNumber_3(target2));
    }
    public static int findRepeatNumber_0(int[] nums) {
        if (nums.length == 0)
            return -1;
        Set<Integer> resultMap = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.contains(nums[i])) {
                return nums[i];
            }
            resultMap.add(nums[i]);
        }
        return -1;
    }

    public static int findRepeatNumber_1(int[] nums) {
        if (nums.length == 0)
            return -1;
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer target = resultMap.get(nums[i]);
            if (target == null) {
                resultMap.put(nums[i], 1);
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    // 错误示范: 没有考虑到初始时就已成功入座的情况。
    public static int findRepeatNumber_2(int[] nums) {
        if (nums.length == 0)
            return -1;

        int temp = 0;
        while(true) {
            if (nums[temp] != nums[nums[temp]]) {
                // 交换
                int t = nums[nums[temp]];
                nums[nums[temp]] = nums[temp];
                temp = t;
            } else {
                return nums[temp];
            }
        }
    }

    public static int findRepeatNumber_3(int[] nums) {
        if (nums.length == 0)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 一直循环
                if (nums[i] != nums[nums[i]]) {
                    // 交换
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                } else {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
