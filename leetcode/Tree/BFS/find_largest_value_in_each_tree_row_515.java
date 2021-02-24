package Tree.BFS;

import java.util.*;

import Tree.TreeNode;

public class find_largest_value_in_each_tree_row_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            Integer max = queue.peek().val;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max,node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        find_largest_value_in_each_tree_row_515 instance = new find_largest_value_in_each_tree_row_515();
        instance.largestValues(new TreeNode(-2147483648,null,null));
    }
}