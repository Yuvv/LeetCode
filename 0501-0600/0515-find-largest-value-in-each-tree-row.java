import java.util.*;

 /**
 Definition for a binary tree node.
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


/*
 * 0515-find-largest-value-in-each-tree-row.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/07
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode node = stack.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
                size--;
            }
            resultList.add(max);
        }
        return resultList;
    }
}