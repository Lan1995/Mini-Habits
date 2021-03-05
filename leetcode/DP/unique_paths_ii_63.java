package DP;

public class unique_paths_ii_63 {

    //1. 重复子问题
    //2. DP表或状态数组
    //3. 状态转移方程
    //f(i,j) = f(i-1,j) + f(i,j-1) => 
    //    f(i,j) = f(i-1,j) + 0  (num[i][j-1] == 1)
    //    f(i,j) = 0 + f(i,j-1)  (num[i-1][j] == 1)
    //    f(i,j) = f(i-1,j) + f(i,j-1) (num[i][j-1] == 0 && num[i-1][j] == 0)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null 
        || obstacleGrid.length == 0 
        || obstacleGrid[0].length ==0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //[[1,0]] 测试用例过不了
        // for (int i = 0; i < m; i++) {
        //     dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : 1;
        // }
        // for (int i = 0; i < n; i++) {
        //     dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : 1;
        // }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        unique_paths_ii_63 instance = new unique_paths_ii_63();
        System.out.println(instance.uniquePathsWithObstacles(new int[][]{{1,0}}));
    }
    
}
