package leetcode.prefixsub;

public class No_724_pivotIndex {
    public static void main(String[] args) {
        No_724_pivotIndex go = new No_724_pivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(go.pivotIndex(nums));
    }
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] sum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i < len; i++) {
            int left = 0, right = 0;
            if (i == 0) {
                left = 0;
            } else {
                left = sum[i - 1];
            }
            right = sum[len] - nums[i];

            if (left == right) return 0;
        }

        return -1;
    }
}
