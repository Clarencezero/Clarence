package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class No_45_jump {
    public static void main(String[] args) {
        No_45_jump go = new No_45_jump();
        int[] nums = {2, 1, 1, 1, 4};
        int jump = go.jump(nums);
        System.out.println(jump);

    }


    public int jump(int[] nums) {
        if (nums.length == 0) return 0;

        int currJmpMax = 0,  //
                currPostMax = 0, // 表示本次"跳"所能达到的最远距离
                jump = 0,        // 总的跳跃次数
                i = 0;           // 指针

        while (i < nums.length - 1) { // 最后一位我们不需要跳了
            // 更新本跳最大位移量
            currPostMax = Math.max(currPostMax, i + nums[i]);

            // 如果i已经走到最右端，这一跳无法跳出这个边界，
            // 那么就可以再跳一跳，跳出这个"舒适区"
            if (i == currJmpMax) {
                jump++;

                // 记录当前跳能到达的最远距离
                currJmpMax = currPostMax;
            }

            i++;
        }


        Integer[] num = {2, 3, 4};
        Arrays.sort(num, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Math.abs((int)o2) - Math.abs((int)o1);
            }
        });

        return jump;
    }
}
