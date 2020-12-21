package Array;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。 示例 1：
 * <p>
 * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1.  1 阶 + 1 阶 2.  2 阶 示例 2：
 * <p>
 * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1.  1 阶 + 1 阶 + 1 阶 2.  1 阶 + 2 阶 3.  2 阶 + 1 阶
 * <p>
 * 解题思路: 思路一：递归 f(1) = 1 f(2) = f(1) + 1 f(3) = f(2) + 1 f(4) = 5 1+1+1+1 1+1+2 1+2+1 2+1+1 2+2 f(5) = 8 1+1+1+1+1
 * 1+1+1+2 1+1+2+1 1+2+1+1 2+1+1+1 2+2+1 2+1+2 1+2+2 递归点：f(n) = f(n-1) + f(n-2) 没想到的点：无法理解，文字解释出规则 对于最后一步，可以爬一个台阶或者两个台阶
 * 如果剩两个台阶，此时1+1已经被包含在剩一个台阶的结果中 官方题解思路 1. 记忆化递归 2. 动态规划：滚动数组 3. 矩阵快速幂 4. 数学公式 结果 1. 单纯递归时间复杂度O(2^n) 2. 记忆化递归O(n)
 */
public class climbing_stairs_70 {

  public int climbStairs(int n) {
    int[] memo = new int[n + 1];
    return fin(n, memo);
  }


  public int fin1(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    return fin1(n - 1) + fin1(n - 2);
  }

  /**
   * 记忆型递归
   */
  public int fin(int n, int[] memo) {
    if (memo[n] > 0) {
      return memo[n];
    }
    if (n == 1) {
      memo[n] = 1;
    } else if (n == 2) {
      memo[n] = 2;
    } else {
      memo[n] = fin(n - 1, memo) + fin(n - 2, memo);
    }
    return memo[n];
  }

  /**
   * 动态规划:滚动数组.
   * 0 0 1
   * 0 1 1
   * 1 1 2
   * 1 2 3
   * 2 3 5
   */
  public int DP(int n) {
    int j = 0, q = 0, r = 1;
    for (int i = 1; i <= n; i++) {
      j = q;
      q = r;
      r = j + q;
    }
    return r;
  }
}
