package DP;


public class maximum_product_subarray_152 {

    public int maxProduct(int[] nums) {
        int maxF = nums[0],minF = nums[0],res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i],mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));            
            res = Math.max(maxF, res);
            System.out.println("maxF:" + maxF + ",minF:" + minF + ",res:" + res);
        }
        return res;
    }

    public static void main(String[] args) {
        maximum_product_subarray_152 instance = new maximum_product_subarray_152();
        int res = instance.maxProduct(new int[]{-4,-3,-2});
        System.out.println(res);
    }
}
