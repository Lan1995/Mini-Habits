package Tree;

import java.util.ArrayList;
import java.util.List;

public class n_ary_tree_preorder_traversal_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        callPreorder(root,res);
        return res;
    }

    private void callPreorder(Node root, List<Integer> res) {
        if(root == null) return;
        //root
        res.add(root.val);
        for (Node child : root.children) {
            callPreorder(child,res);
        }
    }
}
