import java.util.*;


public class TreeNode {
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
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        getSum(root, 0, resList);
        return resList.stream().reduce(0, Integer::sum);
    }

    public void getSum(TreeNode node, int curSum, List<Integer> resList) {
        if (node == null) {
            return;
        }
        curSum = (curSum << 1) + node.val;
        if (node.left == null && node.right == null) {
            resList.add(curSum);
            return;
        }
        if (node.left != null) {
            getSum(node.left, curSum, resList);
        }
        if (node.right != null) {
            getSum(node.right, curSum, resList);
        }
    }
}