package Recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class validate_binary_search_tree_98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //inorder
        List<Integer> res = new ArrayList<>();
        _recursion(root, res);
        for (int i = 0; i < res.size() - 1; i++) {
            int j = i + 1;
            if (res.get(i) >= res.get(j)) return false;
        }
        return true;
    }

    private void _recursion(TreeNode root, List<Integer> res) {
        //terminator
        if (root == null) return;
        //process cur logic
        _recursion(root.left, res);
        //drill down
        res.add(root.val);
        //clear state
        _recursion(root.right, res);
    }


    /**
     * cycle for sort
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        List<Integer> inorder = new ArrayList<>();
        Deque<Object> treeNodes = new LinkedList<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            Object top = treeNodes.pop();
            if (top instanceof TreeNode) {
                TreeNode cur = (TreeNode) top;
                //不能在这判断，应该无法判断到根节点
                if (cur.right != null) treeNodes.push(cur.right);
                treeNodes.push(cur.val);
                if (cur.left != null) treeNodes.push(cur.left);
            } else {
                inorder.add((Integer) top);
                if (inorder.size() > 1 && inorder.get(inorder.size() - 2) >= (Integer) top) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidBST3(TreeNode root) {
        return _recursionSelf(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * @param root
     * @param lower 下界
     * @param upper 上界
     * @return
     */
    private boolean _recursionSelf(TreeNode root, int lower, int upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return _recursionSelf(root.left, lower, root.val) && _recursionSelf(root.right, root.val, upper);
    }

    long pre = Long.MIN_VALUE;

    public boolean isValidBST4(TreeNode root) {
        if (root == null) return true;
        //验证左子树
        if (!isValidBST4(root.left)) return false;
        if (pre >= root.val) return false;
        pre = root.val;
        return isValidBST4(root.right);
    }

    public static void main(String[] args) {
        validate_binary_search_tree_98 generate = new validate_binary_search_tree_98();
        generate.isValidBST(new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)));
        generate.isValidBST2(new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)));
    }
}
