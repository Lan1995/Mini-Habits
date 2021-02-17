package Recursion;

import java.util.HashMap;
import java.util.Map;

public class construct_binary_tree_from_preorder_and_inorder_traversal_105 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;
        //从中序遍历中获取根节点
        //中序遍历:[[左子树],根节点,[右子树]]
        //前序遍历:[根节点,[左子树],[右子树]]
        Integer rootIndex = map.get(preorder[pStart]);
        //build tree
        TreeNode node = new TreeNode(preorder[pStart]);
        int leftNodeNum = rootIndex - iStart;
        //构造preorder 和 inOrder 中相同的部分
        //preorder左子树，inorder中左子树
        node.left = helper(preorder, pStart + 1, pStart + leftNodeNum, inorder, iStart, rootIndex - 1);
        //preorder右子树,inorder中右子树
        node.right = helper(preorder, pStart + leftNodeNum + 1, pEnd, inorder, rootIndex + 1, iEnd);
        return node;
    }
}
