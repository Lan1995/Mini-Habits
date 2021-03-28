package DP;

public class best_time_to_buy_and_sell_stock_iii_123 {
    //dp[i][j][k]
    //  i:前i天
    //  j:当前状态,0为现金,1为持股
    //  k:交易次数
    // dp[i][j][k] = max(dp[i-1][j][k])(k=0,j=0)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) return 0;
        int[][][] dp = new int[prices.length][2][3];
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;//不可能
        dp[0][0][2] = 0;//不可能
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -prices[0];//不可能
        dp[0][1][2] = -prices[0];//不可能
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][1][0] + prices[i], dp[i-1][0][1]);
            dp[i][0][2] = Math.max(dp[i-1][1][1] + prices[i], dp[i-1][0][2]);
            dp[i][1][0] = Math.max(dp[i-1][0][0] - prices[i], dp[i-1][1][0]);
            dp[i][1][1] = Math.max(dp[i-1][0][1] - prices[i], dp[i-1][1][1]);
            dp[i][1][2] = dp[i-1][1][2];
        }
        return Math.max(dp[prices.length - 1][0][1], Math.max(dp[prices.length - 1][0][1],
        Math.max(dp[prices.length - 1][0][2], 0)));
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
