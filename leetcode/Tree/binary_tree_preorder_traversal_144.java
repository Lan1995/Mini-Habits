package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class binary_tree_preorder_traversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        //root
        res.add(root.val);
        //left
        res.addAll(preorderTraversal(root.left));
        //right
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return res;
    }
}
