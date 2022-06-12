package leetcode.dp;

import util.Util;

public class No_53_maxSubArray {
    public static void main(String[] args) {
        No_53_maxSubArray go = new No_53_maxSubArray();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4, 8 , 9 , 10};
        int[] result = go.maxSubArray(arr);
        Util.printArray(result);
    }

    /**
     * 变种：返回最大子序和数组
     *
     * @param nums
     * @return
     */
    public int[] maxSubArray(int[] nums) {
        if (nums.length == 0) return new int[0];

        int start = 0, end = 0;
        int maxV = nums[0], cur = 0;

        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];

            // 需要第一时间更新 maxV 和 cur 的值，否则会出错
            if (cur > maxV) {
                maxV = cur;
                end = i;
            }

            // 这一步表示如果加上 num[i] 是一个小于 0 的数，那么就舍弃这个数，跳到下一个数进行处理
            if (cur < 0) {
                cur = 0;
                start = i + 1;
            }

        }
        int[] result = new int[end - start + 1];

        // 使用 Java API 复制数组
        System.arraycopy(nums, start, result, 0, result.length);
        return result;
    }
}
