import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

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


/*
 * 0129-sum-root-to-leaf-numbers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/06
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.left == null && curNode.right == null) {
                // find a leaf node, just add to sum
                result += curNode.val;
            } else {
                if (curNode.left != null) {
                    curNode.left.val += curNode.val * 10;
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    curNode.right.val += curNode.val * 10;
                    queue.add(curNode.right);
                }
            }
        }
        return result;
    }
}