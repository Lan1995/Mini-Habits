package DP;

import java.util.*;

public class triangle_120 {
    //f(i,j) = f(i-1,j) + Min(num[i,j],num[i,j+1])
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


    public int minimumTotalDFS(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[][] memo = new int[triangle.size()][triangle.size()];
        return dfs(triangle,0,0,memo);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        if(i == triangle.size()) return 0;
        if(memo[i][j] != 0) return memo[i][j];
        return memo[i][j] = Math.min(dfs(triangle, i+1, j, memo),dfs(triangle, i+1, j+1, memo)) + triangle.get(i).get(j);    
    }

}
