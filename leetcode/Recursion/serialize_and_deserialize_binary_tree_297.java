package Recursion;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class serialize_and_deserialize_binary_tree_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        _preOrderRecursion(root, sb);
        return sb.toString();
    }

    private void _preOrderRecursion(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            return;
        }
        _preOrderRecursion(root.left, sb);
        sb.append(root.val).append(",");
        _preOrderRecursion(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deque = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(deque);
    }

    private TreeNode buildTree(Deque<String> deque) {
        String pop = deque.pop();
        if ("null".equals(pop)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(pop));
        node.left = buildTree(deque);
        node.right = buildTree(deque);
        return node;
    }
}
