package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class No_518_change {
    public static void main(String[] args) {
        No_518_change go = new No_518_change();
        int[] coins = {2, 3, 5};
        System.out.println(go.change(5, coins));
    }
    public int change(int amount, int[] coins) {
        if (amount == 0 || coins.length == 0) return 0;
        List<Integer> path = new ArrayList<>();
        backTracking(amount, coins, path, 0);
        return 0;
    }

    private void backTracking(int amount, int[] coins, List<Integer> path, int start) {
        if (amount < 0) return;
        if (amount == 0) {
            System.out.println(path);
            return;
        }

        for (int i = start; i < coins.length; i++) {
            path.add(coins[i]);
            backTracking(amount - coins[i], coins, path, i);
            path.remove(path.size() - 1);
        }
    }

}
