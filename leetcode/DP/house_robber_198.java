package DP;

import jdk.jshell.execution.Util;

public class house_robber_198 {
    //1. 明确状态
    // 1.1 状态1：偷或者不偷
    // 1.2 状态2：房屋数量
    // 背包问题变形
    //2. dp数组
    // 2.1 dp[i][j],i为第几座方位，j为是否偷窃
    //3. 状态转移方程
    // 3.1 dp[i][j] = max{dp[i-1],dp[i-2]+value[i]}

    public int rob(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first+nums[i], temp);
            first = second;
        }

        return second;
        
    }

    public int rob(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        house_robber_198 instance = new house_robber_198();
        int res = instance.rob(new int[]{1,2,3,1});
        System.out.println(res);
    }
}
