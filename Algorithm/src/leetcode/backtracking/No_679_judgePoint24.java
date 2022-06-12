package leetcode.backtracking;

import util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * 求 24 点
 */
public class No_679_judgePoint24 {
    int count = 0;

    public static void main(String[] args) {
        No_679_judgePoint24 go = new No_679_judgePoint24();
        int[] data = {4, 1, 8, 7};
        System.out.println(go.judgePoint24(data));
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) <= 0.00001;
        }
        // 每次递归i都是从0开始，j从1开始
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> copy = new ArrayList<>(nums);
                double b = copy.remove(j), a = copy.remove(i);
                boolean valid = false;
                copy.add(a + b);
                Util.printIndent(count++);
                Util.print(copy, i, j);
                valid |= solve(copy);
                Util.printIndent(count--);

                // 复原
                copy.set(copy.size() - 1, a - b);
                valid |= solve(copy);

                copy.set(copy.size() - 1, b - a);
                valid |= solve(copy);

                copy.set(copy.size() - 1, a * b);
                valid |= solve(copy);

                copy.set(copy.size() - 1, a / b);
                valid |= solve(copy);
                copy.set(copy.size() - 1, b / a);
                valid |= solve(copy);


                if (valid) return true;
            }
        }
        return false;
    }


}
