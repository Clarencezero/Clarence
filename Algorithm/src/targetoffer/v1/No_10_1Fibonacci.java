package jianzhioffer;

/**
 * 斐波那契数列: 又称黄金分割数列。
 * 详见: https://www.zhihu.com/question/28062458
 * F(n) = f(n-1) + f(n-2) f(0) = 0, f(1) = 1
 */
public class No_10_1Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib_1(45)); // 134903163
        System.out.println(fib_2(7)); // 134903163
    }

    /**
     * 思路一: 递归求解
     */
    private static int fib_1(int n) {
        return n < 2 ? 1 : fib_1(n-1) + fib_2(n - 2);
    }



    /**
     * 思路二: 动态规划
     */
    public static int fib_2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i+1] = dp[i] + dp[i-1];
            dp[i+1] %= 1000000007;
        }

        return dp[n];
    }
}
