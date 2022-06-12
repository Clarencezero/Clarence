package leetcode.dp.bag;

import java.util.Arrays;

public class No_518_coinchange_one {
    public static void main(String[] args) {
        No_518_coinchange_one go  = new No_518_coinchange_one();
        int amount = 5;
        int[] coins = {1, 2, 5};
        go.change(amount, coins);
    }

    public int change(int amount, int[] coins) {
        if (amount == 0 || coins.length == 0) return 0;
        int[] memory = new int[amount + 1];
        Arrays.fill(memory, Integer.MAX_VALUE);
        helper(amount, coins, memory, 0);
        // Util.printArray(memory);
        return memory[amount];
    }

    /**
     * 根据给定的 amount，计算从 coins 中所能凑出的最小值，如果没有，则返回 -1
     */
    private int helper(int amount, int[] coins, int[] memory, int k) {
        // if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memory[amount] != Integer.MAX_VALUE)  return memory[amount];
        int minResult = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            // 这里还可以进行剪枝操作
            if (amount - coins[i] < 0) continue;
            printNTab(k);
            System.out.println("amount: " + amount + ", coin: " + coins[i]);

            // 拆分成子问题
            int res = helper(amount - coins[i], coins, memory, k + 1);

            printNTab(k);
            System.out.println("res: " + res);

            // 这句话的意思是，amount 和 coins[i] 不匹配，那么就继续找下一个 coin 和 amount 进行匹配
            if (res == -1) continue;

            // res != -1，表示凑成 amount - coins[i] 所需要 coins 最小的数，然后加上当前的硬币（+1）
            if (res + 1 < minResult) minResult = res + 1;
        }

        memory[amount] = minResult == Integer.MAX_VALUE ? -1 : minResult;
        return memory[amount];
    }

    private void printNTab(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }
}
