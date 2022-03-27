import java.util.*;

/*
 * 1315-sum-of-nodes-with-even-valued-grandparent.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/27
 */
public class Solution {
    private int sum;
    public int sumEvenGrandparent(TreeNode root) {
        this.sum = 0;
        sumEvenGp(root, -1, -1);
        return this.sum;
    }

    void sumEvenGp(TreeNode node, int parentVal, int grandparentVal) {
        if (node == null) {
            return;
        }
        if (grandparentVal % 2 == 0) {
            this.sum += node.val;
        }
        sumEvenGp(node.left, node.val, parentVal);
        sumEvenGp(node.right, node.val, parentVal);
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
