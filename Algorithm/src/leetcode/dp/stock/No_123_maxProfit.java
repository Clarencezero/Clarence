package leetcode.dp.stock;

public class No_123_maxProfit {
    public static void main(String[] args) {
        No_123_maxProfit go = new No_123_maxProfit();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(go.maxProfit(prices));
    }

    /**
     * 第一天都有以下几种状态（k == 2）
     * 持有（不持有）股票、交易 N 次
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // k == 2
        if (prices.length < 2) return 0;
        int len = prices.length;
        // dp[i][j][k] i：天数  j：是否持有股票 k：交易次数
        // 表示第 i 天完成 k 笔交易 持有(1)/不持有(0)股票的最大利润
        int[][][] dp = new int[len][2][3];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE; // 第1天不持有股票但发生交易，这是不可能事件
        dp[0][0][2] = Integer.MIN_VALUE; // 第1天不持有股票但发生交易，这是不可能事件
        dp[0][1][0] = -prices[0];        // 第1天持有股票但未交易
        dp[0][1][1] = Integer.MIN_VALUE; // 第1天持有股票并且交易，这是不可能事件
        dp[0][1][2] = Integer.MIN_VALUE; // 第1天持有股票并且交易，这是不可能事件

        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            // 不持股、卖过一次（继承昨天的 OR 今天卖出）
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);

            // 不持股，卖过两次（继承昨天 OR 今天卖出）
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);

            // 持有股，未卖出过，可能今天买的，也可能之前买的
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);

            // 持有股，卖过一次（继承昨天 OR 今天买入）
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);

            // 持有股，卖过两次（不可能事件）
            dp[i][1][2] = Integer.MIN_VALUE;
        }


        return Math.max(dp[len - 1][0][1], dp[len - 1][0][2]);
    }
}
