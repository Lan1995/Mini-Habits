package DP;

import java.util.*;

public class longest_common_subsequence_1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequence3(String text1, String text2) {
        if(text1 == null || text2 == null ||
           text1.length() == 0 || text2.length() == 0) 
            return 0;
        int m = text1.length();
        int n = text2.length();
        
        
        int[][]dp = new int[m][n];
        
        if(text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < n; i++) {
           if(text1.charAt(0) == text2.charAt(i)){
               dp[0][i] = 1;
           } else {
               dp[0][i] = dp[0][i-1];
           }
        }

        for (int i = 1; i <= m; i++) {
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i-1][0];
            }
         }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + text1.charAt(i) == text2.charAt(j) ? 1 : 0;
                System.out.println("dp[i][j]:" + dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
    //1. 重复子问题
    //2. 状态数组或/DP表
    //数组变成DP表
    //3. 状态转移方程
    //f(i,j) = f(i,j-1) + (0 or 1)  
    public int longestCommonSubsequence2(String text1, String text2) {
    
        int m = text1.length();
        int n = text2.length();
        int[]dp = new int[m];

        for (int i = 0; i < m; i++) {
            if(text2.charAt(0) == text1.charAt(i)){
                dp[i] = 1;
            }else if(i > 0) {
                dp[i] = dp[i-1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j-1] + text1.charAt(i) == text2.charAt(j)?1:0;
            }
        }
        return dp[m-1];
    }

    public static void main(String[] args) {
        longest_common_subsequence_1143 instance = new longest_common_subsequence_1143();
        int res = instance.longestCommonSubsequence("abcde", "ace");
        System.out.println(res);
    }
}
