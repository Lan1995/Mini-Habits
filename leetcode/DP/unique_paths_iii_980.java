package DP;

public class unique_paths_iii_980 {

    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, stepNum = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    continue;
                }
                if(grid[i][j] == 0) stepNum++;
            }
        }
        return dfs(startX,startY,stepNum,grid);
    }

    private int dfs(int x, int y, int stepNum, int[][] grid) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;
        if(grid[x][y] == -1) return 0;
        if(grid[x][y] == 2) return stepNum == 0 ? 1:0;
        grid[x][y] = -1;
        int res = 0;
        res += dfs(x - 1, y, stepNum - 1, grid);
        res += dfs(x + 1, y, stepNum - 1, grid);
        res += dfs(x, y - 1, stepNum - 1, grid);
        res += dfs(x, y + 1, stepNum - 1, grid);
        grid[x][y] = 0;
        return res;    
    }
}
