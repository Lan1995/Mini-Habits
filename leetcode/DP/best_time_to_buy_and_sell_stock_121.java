package DP;

public class best_time_to_buy_and_sell_stock_121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(min < prices[i]) {
                min = prices[i];
            }else if(prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}
