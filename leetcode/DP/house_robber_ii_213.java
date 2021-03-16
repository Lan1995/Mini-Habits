package DP;

import java.util.Arrays;

public class house_robber_ii_213 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int res1 = robber(nums, 0, nums.length -2);
        int res2 = robber(nums, 1, nums.length -1);
        System.out.println(res1);
        System.out.println(res2);
        return Math.max(res1, res2);
    }

    private int robber(int[] nums,int start,int end) {
       if(start == end) return nums[start];
       int pre = nums[start],cur = Math.max(nums[start], nums[start+1]);
       for (int i = start + 2; i <= end; i++) {
           int tmp = cur;
           cur = Math.max(pre + nums[i], cur);
           pre = tmp;
       }
       return cur;
    }

    public static void main(String[] args) {
        house_robber_ii_213 instance = new house_robber_ii_213();
        int res = instance.rob(new int[]{1,2,3,1});
    }
}
