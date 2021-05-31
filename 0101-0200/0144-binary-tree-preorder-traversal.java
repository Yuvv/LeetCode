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
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            TreeNode node = nodeList.pollFirst();
            resultList.add(node.val);
            if (node.right != null) {
                nodeList.addFirst(node.right);
            }
            if (node.left != null) {
                nodeList.addFirst(node.left);
            }
        }
        return resultList;
    }
}