package Array;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * <p>
 * 解题思路: 1. 完全没考虑到去重 2. three_sum -> two sum
 * 方法一：
 * 1. 通过排序来去除重复的值
 *  1.1 碰见重复值也需要过滤
 * 2. 变3sum -> 2sum，记录多个结果
 * 3. 2sum -> 双指针法
 * 4. L + R == target
 *
 */
public class three_sum_15 {


  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 2) {
      return new ArrayList<>();
    }
    Arrays.sort(nums);

    List<List<Integer>> result = new ArrayList<>();
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      //1. 判断i和i-1是否相同，如果相同就跳过
      if(i > 0 && nums[i] == nums[i-1]){
        continue;
      }
      int target = nums[i];
      int r = length-1;
      //2. 双指针判断两数和是否等于target
      //2.1 双指针判断时候也需要判重
      for (int l = i+1; l < length; l++) {
        if (l > i+1 && nums[l] == nums[l - 1]) {
          continue;
        }
        while (l < r && nums[l] + nums[r] + target > 0) {
          r--;
        }
        if (l == r) {
          break;
        }
        if (nums[l] + nums[r] + target == 0) {
          List<Integer> list = new ArrayList<Integer>();
          list.add(nums[i]);
          list.add(nums[l]);
          list.add(nums[r]);
          result.add(list);
        }
      }}
    return result;
  }
}
