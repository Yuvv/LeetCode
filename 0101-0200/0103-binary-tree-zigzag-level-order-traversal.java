import java.uti.List;
import java.uti.ArrayList;
import java.uti.LinkedList;


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
 * 0103-binary-tree-zigzag-level-order-traversal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/06
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> nodeList = new LinkedList<>();
            List<Integer> curList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                curList.add(node.val);
                if (leftToRight) {
                    // current level traversals from left to right, next level from right to left
                    if (node.left != null) {
                        nodeList.addFirst(node.left);
                    }
                    if (node.right != null) {
                        nodeList.addFirst(node.right);
                    }
                } else {
                    // current level traversals from right to left, next level from left to right
                    if (node.right != null) {
                        nodeList.addFirst(node.right);
                    }
                    if (node.left != null) {
                        nodeList.addFirst(node.left);
                    }
                }
            }
            result.add(curList);
            queue.addAll(nodeList);
            leftToRight = !leftToRight;
        }
        return result;
    }
}