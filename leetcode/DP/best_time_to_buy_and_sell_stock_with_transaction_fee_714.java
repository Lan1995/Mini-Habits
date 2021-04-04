package DP;

import java.util.*;

import src.main.Util;

public class best_time_to_buy_and_sell_stock_with_transaction_fee_714 {

    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 0) return 0;
        int buy = -prices[0];
        int sell = 0;  
        for (int i = 1; i < prices.length; i++) {
            // int newBuy = Math.max(buy, sell - prices[i]);
            // int newSell = Math.max(sell, buy + prices[i] - fee);
            // buy = newBuy;
            // sell = newSell;    
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    public int maxProfit2(int[] prices, int fee) {
        if(prices.length == 0) return 0;
        int[]buy = new int[prices.length + 1];
        int[]sell = new int[prices.length + 1];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee);
        }

        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        best_time_to_buy_and_sell_stock_with_transaction_fee_714 instance = new best_time_to_buy_and_sell_stock_with_transaction_fee_714();
        int max = instance.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        Util.print("max profix:{}", max);
    }
}
