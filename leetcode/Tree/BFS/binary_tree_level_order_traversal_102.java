package Tree.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import Tree.TreeNode;

public class binary_tree_level_order_traversal_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(ans.size() > 0) res.add(ans);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        res.add(Arrays.asList(root.val));
        while(!queue.isEmpty()) {
            var size = queue.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
            
                    if(node.left !=null) {
                        ans.add(node.left.val);
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        ans.add(node.right.val);
                        queue.offer(node.right);
                    } 
            }
            if(ans.size() > 0) res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {
        binary_tree_level_order_traversal_102 instance = new binary_tree_level_order_traversal_102();
        instance.levelOrder(new TreeNode(3, new TreeNode(9, null, null),new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null
        ))));
    }
}