import java.util.*;

/*
 * 1448-count-good-nodes-in-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/17
 */

// Definition for a binary tree node.
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
    private int totalCount;
    public int goodNodes(TreeNode root) {
        //
        if (root == null) {
            return 0;
        }
        totalCount = 0;
        walk(root, root.val - 1);
        return totalCount;
    }

    public void walk(TreeNode node, int curMax) {
        if (node == null) {
            return;
        }
        if (node.val >= curMax) {
            curMax = node.val;
            totalCount++;
        }
        if (node.left != null) {
            walk(node.left, curMax);
        }
        if (node.right != null) {
            walk(node.right, curMax);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.goodNodes(new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)))));
        // 3
        System.out.println(s.goodNodes(new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null)));
    }
}