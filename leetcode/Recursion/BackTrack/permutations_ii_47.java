package Recursion.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations_ii_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return null;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, 0, nums.length, path, used, res);
        return res;
    }

    private void backTrack(int[] nums, int level, int max, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (level == max) {
            res.add(path);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);
                boolean[] newUsed = new boolean[nums.length];
                System.arraycopy(used, 0, newUsed, 0, nums.length);
                newUsed[i] = true;
                backTrack(nums, level + 1, max, newPath, newUsed, res);
            }
        }
    }

    public static void main(String[] args) {
        permutations_ii_47 test = new permutations_ii_47();
        System.out.println(test.permuteUnique(new int[]{1, 1, 2}));

    }
}
