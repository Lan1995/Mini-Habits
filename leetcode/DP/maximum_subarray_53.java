package DP;

public class maximum_subarray_53 {
//f(i) = f(i-1) + 0/num[i]
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }


    //f(i) = f(i-1) + 0/num[i]
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length+1];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        maximum_subarray_53 instance = new maximum_subarray_53();
        int res = instance.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
}
