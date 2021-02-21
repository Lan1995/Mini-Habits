package Recursion.DivideConquer;

public class majority_element_169 {
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candicate = null;
        for (int num : nums) {
            if(count == 0) candicate = num;
            count+=(num == candicate) ? 1:-1;
        }
        return candicate;
    }

    public int majorityElement(int[] nums) {
        return majorityElementForDiv(nums,0,nums.length);
    }

    private int majorityElementForDiv(int[] nums, int left, int right) {
        if(left >= right) return nums[0];

        int mid = (right - left)/2 + left;

        int leftRes = majorityElementForDiv(nums,left,mid);
        int rightRes = majorityElementForDiv(nums,mid+1,right);

        if(leftRes == rightRes) return leftRes;
        int leftCount = majorityElementCount(nums,left,mid,leftRes);
        int rightCount = majorityElementCount(nums,mid+1,right,rightRes);

        return leftCount>rightCount?leftRes:rightRes;
    }

    private int majorityElementCount(int[] nums, int left, int mid,int x) {
        int count = 0;
        for (int i = left; i < mid; i++) {
            if(nums[left] == x) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        majority_element_169 test = new majority_element_169();
    }

}
