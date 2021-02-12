package Recursion;

public class invert_binary_tree_266 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        //process cur logic
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //drill down
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
}
