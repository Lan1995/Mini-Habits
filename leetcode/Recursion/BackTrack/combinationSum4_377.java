package Recursion.BackTrack;

import java.util.HashMap;
import java.util.Map;

public class combinationSum4_377 {

  public int combinationSum4_1(int[] nums, int target) {
    if (target < 0) {
      return 0;
    }
    if (target == 0) {
      return 1;
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res += combinationSum4_1(nums, target - nums[i]);
    }
    return res;
  }

  Map<Integer, Integer> map = new HashMap<>();

  public int combinationSum4_2(int[] nums, int target) {
    return backTrace(nums, target);
  }

  private int backTrace(int[] nums, int target) {
    if (target == 0) {
      return 1;
    }
    if (map.containsKey(target)) {
      return map.get(target);
    }

    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (target >= nums[i]) {
        res += backTrace(nums, target - nums[i]);
      }
    }
    map.putIfAbsent(target, res);
    return res;
  }


  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (num <= i) {
          dp[i] += dp[i - num];
        }
      }
    }
    return dp[target];
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    combinationSum4_377 instance = new combinationSum4_377();
    int result = instance.combinationSum4_2(nums, 4);
    System.out.println(result);
  }
}
