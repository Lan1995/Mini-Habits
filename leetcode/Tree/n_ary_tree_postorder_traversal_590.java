package Tree;

import java.util.ArrayList;
import java.util.List;

public class n_ary_tree_postorder_traversal_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        callPostorder(root,res);
        return res;
    }

    private void callPostorder(Node root, List<Integer> res) {
        if(root == null) return;
        for (Node child : root.children) {
            callPostorder(child,res);
        }
        //root
        res.add(root.val);
    }
}
