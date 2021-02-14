package Recursion;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class lowest_common_ancestor_of_a_binary_tree_236 {
    //方法1：
    //get p and q parentList
    //if p,q in one tree , so lowestCommonAncestor is p or q
    //if p,q not in one tree, so lowestCommonAncestor is intersection
    //方法2:
    //1.中序遍历出一个数组[左子树,根节点,右子树]
    //
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
