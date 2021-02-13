import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BeautifulCode {

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<Object> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Object pop = stack.pop();
            if (pop instanceof Integer) {
                res.addLast((Integer) pop);
            } else {
                TreeNode treeNode = (TreeNode) pop;
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                stack.push(new Integer(treeNode.val));
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
            }
        }
        return res;
    }
}
