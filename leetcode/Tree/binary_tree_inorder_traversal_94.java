package Tree;

import java.util.ArrayList;
import java.util.List;

public class binary_tree_inorder_traversal_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        //decision child node
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }

        //left
        list.addAll(inorderTraversal(root.left));
        //root
        list.add(root.val);
        //right
        list.addAll(inorderTraversal(root.right));
        return list;
    }


    public List<Integer> inorder(TreeNode root) {
        //decision child node
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,null,new TreeNode(2,new TreeNode(3,null,null),null));
        System.out.println(inorderTraversal(treeNode));
    }
}
