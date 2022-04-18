/*
 * 0998-maximum-binary-tree-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/18
 */
public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root.val < val) {
            return new TreeNode(val, root, null);
        }
        TreeNode parent = null;
        TreeNode cursor = root;
        while (cursor != null && cursor.val > val) {
            parent = cursor;
            cursor = cursor.right;
        }
        parent.right = new TreeNode(val, cursor, null);
        return root;
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
