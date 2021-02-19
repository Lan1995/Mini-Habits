package Recursion.BackTrack;

import java.util.*;

public class permutations_46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 0) return res;
        LinkedList<Integer> path = new LinkedList<>();
        Set<Integer> memo = new HashSet<>();
        Arrays.sort(nums);
        backTrack(nums, path, memo);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> path, Set<Integer> memo) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!memo.contains(nums[i])) {
                path.add(nums[i]);
                memo.add(nums[i]);
                backTrack(nums, path, memo);
                memo.remove(nums[i]);
                path.removeLast();
            }

        }
    }

    public static void main(String[] args) {
        permutations_46 test = new permutations_46();
        test.permute(new int[]{1, 2, 3});
        System.out.println(test.res);
    }
}
