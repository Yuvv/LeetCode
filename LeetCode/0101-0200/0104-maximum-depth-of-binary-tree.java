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
     * 二叉树深度（遍历即可）
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxLevel = new int[1];
        maxLevel[0] = 0;
        walk(root, maxLevel, 0);
        return maxLevel[0];
    }

    void walk(TreeNode node, int[] maxLevel, int curLevel) {
        if (node != null) {
            curLevel += 1;
            if (curLevel > maxLevel[0]) {
                maxLevel[0] = curLevel;
            }
            walk(node.left, maxLevel, curLevel);
            walk(node.right, maxLevel, curLevel);
        }
    }
}