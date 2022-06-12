package leetcode; 

/*
 * @lc app=leetcode.cn id=283 lang=java
 * 
 * 思路：有两个指针，指针j做++，不断更新数据
 * 指针i遍历，当遇到不为0的数就赋值给j
 * 
 * [283] 移动零
 */
// @lc code=start
class No_283_moveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        // moveZeroes(arr);
        System.out.println(-6%5);
    }
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) return ;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];

                // 优化点：如果一次遍历就完成
                // 对指针i来说，它如果比j快，那么当i!=j时就可以将i指向的元素置为0
                // 因为i指向的元素已经和j置换了
                if (i != j) nums[i] = 0;
                j++;
            }
        }

        // 解法一：重新遍历一次，将剩余位置为0
        // for(int i = j; i < nums.length; i++) {
        //     nums[i] = 0;
        // }

    }
}
// @lc code=end

