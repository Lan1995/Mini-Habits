package DP;

import java.util.*;

import src.main.Util;

public class perfect_squares_279 {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        perfect_squares_279 instance = new perfect_squares_279();
        int count = instance.numSquares(12);
        Util.print("result:{}", count);
    }
}
