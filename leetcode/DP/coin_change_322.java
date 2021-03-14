package DP;

import java.util.*;

import src.main.Util;

public class coin_change_322 {
    public int coinChange(int[] coins, int amount) {
        if(null == coins || coins.length == 0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount? -1:dp[amount];
    }
    Integer res = Integer.MAX_VALUE;
    public int coinChangeGreedy(int[] coins, int amount) {
        if(null == coins || coins.length == 0) return -1;
        Arrays.sort(coins);
        greedyAndDFS(coins,amount,coins.length - 1,0);
        return res  == Integer.MAX_VALUE ? -1 : res;
    }
    private void greedyAndDFS(int[] coins, int amount, int index,int cur) {
        if(amount == 0) {
            res = Math.min(res,cur);
            return;
        }
        if(index < 0) return;
        for (int k = amount/coins[index]; k>=0 && k + cur < res; k--) {
            greedyAndDFS(coins, amount - k*coins[index], index - 1, cur + k);
        }
    }

    //f(n) = min(f(n-1)...f(n-i))+1
    public int coinChangeDP(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        Map<Integer,Integer> memo = new HashMap<>();
        return dfs(memo, coins, amount);
    }
    private Integer dfs(Map<Integer, Integer> memo, int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;

        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }
        Integer res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            Integer min = dfs(memo, coins, amount - coins[i]);
            //Util.print("amount:{},min:{}",amount - coins[i],min);
            //res < min 原因为可能会有多个结果,所以取最小结果
            if(min >= 0 && min < res) {
                res = min + 1;
            }
        }
        //return memo.put(amount, res == Integer.MAX_VALUE ? -1:res);
        memo.put(amount, res == Integer.MAX_VALUE ? -1:res);
        return memo.get(amount);
    }

    public static void main(String[] args) {
        coin_change_322 instance = new coin_change_322();
        int res = instance.coinChangeDP(new int[]{1, 2, 5}, 11);
        System.out.println(res);
        int res2 = instance.coinChangeGreedy(new int[]{1, 2, 5}, 11);
        System.out.println(res2);
        int res3 = instance.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res3);
    }
}
