package Binary;

public class find_minimum_in_rotated_sorted_array_153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1,mid = 0;
        while(left <= right) {
             mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        find_minimum_in_rotated_sorted_array_153 test = new find_minimum_in_rotated_sorted_array_153();
        System.out.println(test.findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
