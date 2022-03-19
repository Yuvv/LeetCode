import java.util.*;

/*
 * 0814-binary-tree-pruning.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/19
 */
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,null,0,null,1]
        System.out.println(s.pruneTree(
            new TreeNode(1, null, new TreeNode(0, new TreeNode(0), new TreeNode(1)))
        ));
    }
}


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
