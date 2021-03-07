package DP;

public class climbing_stairs_70 {

    //f(n) = f(n-1) + f(n-2)
    public int climbStairs(int n) {
       int a = 0,b = 0,res = 1;
       for (int i = 1; i <= n; i++) {
           a = b;
           b = res;
           res = a + b;
       }
       return res;
      }
}
