package jianzhioffer;

public class No_14_1_Cut_the_rope {
    public static void main(String[] args) {
        // System.out.println(cuttingRope_1(3));
        // System.out.println(cuttingRope_1(7));
        System.out.println(cuttingRope_3(120));
    }

    /**
     * 递归: F(n) = Max(i*(n-i), i*F(n-i))
     */
    public static int cuttingRope_1(int n) {
        if (n == 2) {
            return 1;
        }
        int ret = -1;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, Math.max(i * (n - i), i * cuttingRope_1(n - i)));
        }
        return ret;
    }

    /**
     * 记忆递归数据
     */
    public static int cuttingRope_2(int n) {
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 1;
        temp[2] = 1;

        for (int i = 3; i < n; i++) {
            if (temp[i] != 0) {
                return temp[i];
            }
            temp[i] = Math.max(temp[i], Math.max(i * (n - i), i * cuttingRope_1(n - i)));
        }
        return temp[n];
    }


    /**
     * 动态规划: dp[n] 表示整数n最大乘积
     * 重点:
     * ① 递推式: dp[n] = Max(dp[n], Max(i*(n-i), i*dp[n-i]))
     * ② 如何构造i，i表示什么含义。i 表示切的长度，n-i 表示剩下的长度
     */
    public static int cuttingRope_3(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                System.out.println(String.format("i:%s, j:%s, dp[i]:%s", i, j, dp[i]));
            }
        }
        return dp[n];
    }
}
