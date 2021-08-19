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
 * 1339-maximum-product-of-splitted-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/19
 */
public class Solution {
    public int maxProduct(TreeNode root) {
        // build node sum map
        Map<TreeNode, Long> nodeSumMap = new HashMap<>();
        nodeSumMap.put(null, 0L);
        getTreeNodeSum(nodeSumMap, root);

        // get max product
        Long maxProduct = 0L;
        Long totalSum = nodeSumMap.get(null);
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (nodeList.size() > 0) {
            TreeNode node = nodeList.pop();
            Long curProduct = nodeSumMap.get(node) * (totalSum - nodeSumMap.get(node));
            if (curProduct > maxProduct) {
                maxProduct = curProduct;
            }
            if (node.left != null) {
                nodeList.add(node.left);
            }
            if (node.right != null) {
                nodeList.add(node.right);
            }
        }
        return (int) (maxProduct % 1000000007L);
    }

    public Long getTreeNodeSum(Map<TreeNode, Long> nodeSumMap, TreeNode node) {
        if (node == null) {
            return 0L;
        }
        Long curSum = Long.valueOf(node.val);
        if (node.left != null) {
            curSum += getTreeNodeSum(nodeSumMap, node.left);
        }
        if (node.right != null) {
            curSum += getTreeNodeSum(nodeSumMap, node.right);
        }
        nodeSumMap.put(null, nodeSumMap.get(null) + node.val);
        nodeSumMap.put(node, curSum);
        return curSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 110
        System.out.println(s.maxProduct(new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4), new TreeNode(5)),
            new TreeNode(3,
                new TreeNode(6), null))));
    }
}