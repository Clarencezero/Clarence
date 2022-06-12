package leetcode.dp;

public class No_300_lengthOfLIS {
    public static void main(String[] args) {
        No_300_lengthOfLIS go = new No_300_lengthOfLIS();
        int[] nums = {10,9,2,5,3,7,101,18};
        int i = go.lengthOfLIS(nums);
        System.out.println("final: " + i);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] top = new int[nums.length];
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 通过二分搜索 top，找到合适的top位置并更新，如果找不到，那么将 nums[i] 放入 cur+1中
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] == nums[i]) {
                    right = mid;
                } else if (top[mid] > nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == piles) piles++;
            top[left] = nums[i];
            print(top);
        }
        return piles;
    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
