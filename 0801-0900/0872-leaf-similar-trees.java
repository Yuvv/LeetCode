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


/*
 * 0872-leaf-similar-trees.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/12
 */
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = getLeaf(root1);
        List<Integer> leaf2 = getLeaf(root2);
        if (leaf1.size() != leaf2.size()) {
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++) {
            if (!leaf1.get(i).equals(leaf2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getLeaf(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            if (curNode.left == null && curNode.right == null) {
                result.add(curNode.val);
            } else {
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
                if (curNode.left != null) {
                    stack.push(curNode.left);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // blah
    }
}