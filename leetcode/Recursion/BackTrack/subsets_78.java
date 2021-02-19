package Recursion.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(0, nums, res, path);
        return res;
    }

    private void backTrack(int level, int[] nums, List<List<Integer>> res, List<Integer> path) {
        if(level == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        backTrack(level+1,nums,res,path);

        path.add(nums[level]);
        backTrack(level+1,nums,res,path);
        path.remove(path.size() -1);
    }
}
