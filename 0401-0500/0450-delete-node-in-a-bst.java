import java.util.*;

/**
 * Definition for a binary tree node.
 */
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            TreeNode node = root.right;
            if (node == null) {
                return root.left;
            }
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            return root.right;
        }

        // left
        if (!traceNode(root, root.left, true, key)) {
            // right
            traceNode(root, root.right, false, key);
        }
        return root;
    }

    public boolean traceNode(TreeNode parentNode, TreeNode node, boolean isLeft, int key) {
        if (node == null) {
            return false;
        }
        if (node.val == key) {
            if (isLeft) {
                if (node.right == null) {
                    parentNode.left = node.left;
                } else {
                    parentNode.left = node.right;
                    TreeNode nodeLeft = node.left;
                    node = node.right;
                    while (node.left != null) {
                        node = node.left;
                    }
                    node.left = nodeLeft;
                }
            } else {
                if (node.left == null) {
                    parentNode.right = node.right;
                } else {
                    parentNode.right = node.left;
                    TreeNode nodeRight = node.right;
                    node = node.left;
                    while (node.right != null) {
                        node = node.right;
                    }
                    node.right = nodeRight;
                }
            }
            return true;
        }
        return traceNode(node, node.left, true, key) || traceNode(node, node.right, false, key);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.deleteNode(new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(7))),
            7));

        System.out.println(s.deleteNode(new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(7))),
            3));

        System.out.println(s.deleteNode(new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(7))),
            0));

        System.out.println(s.deleteNode(null, 0));
    }
}