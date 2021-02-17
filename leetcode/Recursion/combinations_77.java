package Recursion;

import java.util.ArrayList;
import java.util.List;

public class combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        _recursion(1, n, res);
        return null;
    }

    private void _recursion(int level, int n, List<List<Integer>> res) {
        //terminator
        if(level >= n) return;
        //process cur logic
        List<Integer> curRes = new ArrayList<>();
        for (int i = level; i < n; i++) {
            //curRes.add()
        }
        //drill down

        //clear state
    }
}
