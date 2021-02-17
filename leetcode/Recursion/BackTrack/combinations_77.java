package Recursion.BackTrack;

import java.util.*;

public class combinations_77 {
    List<List<Integer>> res = new ArrayList<>();

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return res;
        LinkedList<Integer> ans = new LinkedList<>();
        backTrack(1, k, n, ans);
        return res;
    }

    private void backTrack(int level, int k, int n, LinkedList<Integer> ans) {
        //terminator
        if (ans.size() >= k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        //k-ans.size() 还差几个元素没选择
        //n - (k-ans.size) 为上界,如果level超过上界则无法凑齐元素
        for (int i = level; i <= n - (k - ans.size()) + 1; i++) {
            //do n
            ans.add(i);

            //drill down
            //[1,1] pruning
            backTrack(i + 1, k, n, ans);
            //clear state
            ans.removeLast();
        }
    }

    private void backTrackV1(int level, int k, int n, LinkedList<Integer> ans) {
        //terminator
        if (ans.size() >= k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        //process cur level logic
        for (int i = level; i <= n; i++) {
            //do n
            ans.add(i);

            //drill down
            //[1,1] pruning
            backTrack(i + 1, k, n, ans);
            //clear state
            ans.removeLast();
        }
    }

    private void backTrack(int k, int n, LinkedList<Integer> ans) {
        //terminator
        if (ans.size() >= k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        //process cur level logic
        for (int i = 1; i < n; i++) {
            //do n
            ans.add(i);
            //drill down
            backTrack(k, n, ans);
            //clear state
            ans.removeLast();
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

    public static void main(String[] args) {
        combinations_77 test = new combinations_77();
        test.combine(4, 2);
        System.out.println(test.res);
    }
}
