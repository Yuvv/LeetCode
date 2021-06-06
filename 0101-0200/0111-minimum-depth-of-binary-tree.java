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
 * 0111-minimum-depth-of-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/06
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    // get a leaf node
                    return depth;
                }
                if (curNode.left != null) {
                    nextLevel.add(curNode.left);
                }
                if (curNode.right != null) {
                    nextLevel.add(curNode.right);
                }
            }
            queue.addAll(nextLevel);
            depth++;
        }
        return depth;
    }
}