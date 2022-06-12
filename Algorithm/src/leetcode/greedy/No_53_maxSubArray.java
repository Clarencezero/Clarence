package leetcode.greedy;

public class No_53_maxSubArray {
    public static void main(String[] args) {
        No_53_maxSubArray go = new No_53_maxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // int[] nums = {-1,2,-3,-4};
       go.maxSubArray(nums);
    }

    /**
     * 返回具有最大和的连续子数组
     * left：先判断max
     * @param nums
     * @return
     */
    public void maxSubArray(int[] nums) {
        if (nums.length == 0) return;
        //
        int finalLeft = 0, finalRight = 0;

        int left = 0;

        int maxSum = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];

            if (cur > maxSum) {
                // 取到最大值就可以更新finalLeft和finalRight了
                maxSum = cur;
                finalLeft = left;
                finalRight = i;
            }
            if (cur < 0) {
                cur = 0;
                left = i + 1;
            }
        }
    }

}
