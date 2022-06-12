package leetcode.dp.bag;

/**
 * 这题是爬楼梯的变种：一步一个台阶，两个台阶、三个台阶 ... 直到 m 个台阶，问有多少种不同的方法可以爬到楼顶 ?
 * 解析：这就是一个完全背包问题。1阶、2阶、3阶 是物品，物品可以重复使用。楼顶就是背包，问装满背包有多少种方式?
 */
public class No_70_climbStairs {
    public static void main(String[] args) {

    }

    private int climbStairs(int n, int m) {
        // dp[i] 表示爬到 n 共有 n 种方式
        int[] dp = new int[n + 1];
        dp[1] = 1;

        // 2 5 和 5 2 是不一样的，这是排列问题，那就需要先遍历背包
        for (int i = 1; i <= n; i++) { // 遍历背包
            for (int j = 1; j <= m; j++) { // 遍历物品
                if (i - j >= 0) dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
