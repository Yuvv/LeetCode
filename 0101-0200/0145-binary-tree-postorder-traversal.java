/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        if (root.left != null) {
            resultList.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            resultList.addAll(postorderTraversal(root.right));
        }
        resultList.add(root.val);

        return resultList;
    }
}