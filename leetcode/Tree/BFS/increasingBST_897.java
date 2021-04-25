package Tree.BFS;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class increasingBST_897 {


  public TreeNode increasingBST(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    bfs(root, values);
    TreeNode dumpNode = new TreeNode(-1);
    TreeNode curNode = dumpNode;
    for (int i = 0; i < values.size(); i++) {
      curNode.right = new TreeNode(values.get(i));
      curNode = curNode.right;
    }
    return dumpNode.right;
  }

  private void bfs(TreeNode root, List<Integer> values) {
    if (root == null) {
      return;
    }
    bfs(root.left, values);
    values.add(root.val);
    bfs(root.right, values);
  }

  TreeNode res = new TreeNode(-1);

  public TreeNode increasingBST_2(TreeNode root) {
    TreeNode dump = res;
    bfs2(root);
    return dump.right;
  }

  private void bfs2(TreeNode root) {
    if (root == null) {
      return;
    }
    bfs2(root.left);

    res.right = root;
    root.left = null;
    res = root;

    bfs2(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5, new TreeNode(1, null, null), new TreeNode(7, null, null));
    increasingBST_897 instance = new increasingBST_897();
    TreeNode result = instance.increasingBST(root);
    System.out.println(result.toString());
  }
}
