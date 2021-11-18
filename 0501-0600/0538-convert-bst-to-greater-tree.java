import java.util.*;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> sl = new ArrayList<>(1);
        sl.add(0);
        rdfs(root, sl);
        return root;
    }

    public void rdfs(TreeNode node, List<Integer> sl) {
        if (node.right != null) {
            rdfs(node.right, sl);
        }
        sl.set(0, sl.get(0) + node.val);
        node.val = sl.get(0);
        if (node.left != null) {
            rdfs(node.left, sl);
        }
    }
}