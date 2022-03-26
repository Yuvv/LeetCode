
/*
 * 1038-binary-search-tree-to-greater-sum-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/26
 */
public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root, 0);
        return root;
    }

    public int bstToGst(TreeNode node, int parentLartSum) {
        int rightSum = 0;
        if (node.right != null) {
            rightSum = bstToGst(node.right, parentLartSum);
            node.val += rightSum;
        } else {
            node.val += parentLartSum;
        }
        int leftSum = node.val;
        if (node.left != null) {
            leftSum = bstToGst(node.left, node.val);
        }
        return leftSum;
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
