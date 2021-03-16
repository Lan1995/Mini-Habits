package Binary;

public class search_in_rotated_sorted_array_33 {

    //二分搜索
    //1. mid = left + (right - left) / 2
    //2. 无论target在左边或者右边 都会有一边不是升序的
    //3. 首先需要判断target位置
    public int searchOri(int[] nums, int target) {
        int res = -1;
        if(nums == null || nums.length == 0) return res;
        int left = 0,right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            //判断旋转位置和target
            if(nums[mid -1] > nums[left]) {
                if(target > nums[mid -1]) {
                    left = mid + 1;
                }else{}
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段 
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
