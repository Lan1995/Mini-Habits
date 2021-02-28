package greedy;

public class best_time_to_buy_and_sell_stock_ii_122 {
    public int maxProfit(int[] prices) {
        int amount = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                amount += prices[i + 1] - prices[i];
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        best_time_to_buy_and_sell_stock_ii_122 test = new best_time_to_buy_and_sell_stock_ii_122();
        System.out.println(test.maxProfit(new int[]{}));
    }
}
