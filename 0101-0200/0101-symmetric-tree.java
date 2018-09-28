/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 判断树是否镜像（遍历即可）
     * https://leetcode.com/problems/symmetric-tree/description/
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> leftQueue = new LinkedList<>();
        LinkedList<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.addLast(root.left);
        rightQueue.addLast(root.right);

        TreeNode leftNode, rightNode;

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            leftNode = leftQueue.pop();
            rightNode = rightQueue.pop();
            if (leftNode != null && rightNode != null) {
                if (leftNode.val == rightNode.val) {
                    leftQueue.addLast(leftNode.left);
                    leftQueue.addLast(leftNode.right);
                    rightQueue.addLast(rightNode.right);
                    rightQueue.addLast(rightNode.left);
                } else {
                    return false;
                }
            } else if (!(leftNode == null && rightNode == null)) {
                return false;
            }
        }

        return leftQueue.isEmpty() && rightQueue.isEmpty();
    }
}