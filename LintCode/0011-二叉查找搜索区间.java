/**
 * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。
 * 找到树中所有值在 k1 到 k2 范围内的节点。即打印所有x (k1 <= x <= k2) 其中 
 * x 是二叉查找树的中的节点值。返回所有升序的节点值。
 */


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        
        if(root != null) {
            getRange(root, k1, k2, list);
        }
        
        return list;
    }
    
    void getRange(TreeNode node, int k1, int k2, List<Integer> list) {
        
        if(node.left != null && node.val > k1) {
            getRange(node.left, k1, k2, list);
        }
        
        if(node.val >= k1 && node.val <= k2) {
            list.add(node.val);
        }
        
        if(node.right != null && node.val < k2) {
            getRange(node.right, k1, k2, list);
        }
    }
}