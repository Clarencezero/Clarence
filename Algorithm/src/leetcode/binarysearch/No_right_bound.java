package leetcode.binarysearch;

public class No_right_bound {
    public static void main(String[] args) {
        No_right_bound go = new No_right_bound();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(go.getRight(nums, 6));
    }
    private int getRight(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        // while (left < right) {
        //     // int mid = (left + right) / 2;
        //     int mid = left + (right - left) / 2;
        //     if (nums[mid] == target) {
        //         left = mid + 1; // 注意
        //     } else if (nums[mid] < target) {
        //         left = mid + 1;
        //     } else if (nums[mid] > target) {
        //         right = mid;
        //     }
        // }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意

        // if (nums.length == 0) return -1;
        // int left = 0, right = nums.length;

        //
        // return nums[left - 1] == target ? left - 1 : -1;
    }
}
