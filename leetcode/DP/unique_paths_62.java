package DP;

import java.util.*;

import javax.swing.Box.Filler;
public class unique_paths_62 {
    //1. 分治：最优子结构(重复性)
    //f(i,j) = f(i-1,j) + f(i,j-1)
    //2. 状态数组/DP表
    //3. 状态转移方程
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //此时dp[i-1]已经被计算为新值,当前dp[i]为上一行的值
                dp[j]+=dp[j-1];
            }
        }
        return dp[m-1];
    }

    public int uniquePaths2(int m, int n) {
        int dp[][] = new int[m][n];
        //第一列为1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行为1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    Integer res = 0;
    public int uniquePathsBackTrack(int m, int n) {
        if(m == 0 || n == 0) return 0;
        _backtrack(1,1,m,n);
        return res;
    }

    private void _backtrack(int mi, int nj, int m, int n) {
        //1. terminator
        if(mi > m || nj > n) return;
        if(mi == m && nj == n) {
            res++;
            return;
        }
        //2 process cur logic

        //3. drill down
        //right++
        _backtrack(mi+1, nj, m, n);
        //down++
        _backtrack(mi, nj+1, m, n);

        //4. clear state
    }

    public int uniquePathsDivide(int m, int n) {//递归
        return uniquePathsHelper(m, n, new HashMap<String, Integer>());
    }
    public int uniquePathsHelper(int m, int n, HashMap<String, Integer> map) {
        if (m<=1||n<=1) return 1;
        String key = m +"s"+ n;
        if (map.containsKey(key))return map.get(key);
        int right = uniquePathsHelper( m, n-1, map);
        int down = uniquePathsHelper( m-1, n, map);
        int total = right + down;
        map.put(key, total);
        return total;
    }

    public static void main(String[] args) {
    unique_paths_62 instance = new unique_paths_62();
    instance.uniquePathsBackTrack(3, 2);
    System.out.println(instance.res);
    //System.out.println(instance.uniquePathsBackTrack(3, 7));
    }


}