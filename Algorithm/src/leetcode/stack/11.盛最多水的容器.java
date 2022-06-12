package leetcode.stack;
/**
 * [11] 盛最多水的容器
 * 
 *
 * 
 */

// @lc code=start
class Solution {


    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, Math.min(height[i], height[j] * (j-1)));
            }
        }

        return result;
    }
}
// @lc code=end

