import java.util.*;

/**
 * 1609-even-odd-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/13
 */
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode lastNode = null;
            while (size > 0) {
                TreeNode node = queue.pollFirst();
                if (level % 2 == node.val % 2) {
                    // even-level with odd-value
                    // odd-level with even-value
                    //System.out.println("level=" + level);
                    return false;
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                if (lastNode != null) {
                    int c = node.val - lastNode.val;
                    if (level % 2 == 0 ) {
                        if (c <= 0) {
                            //System.out.println(">= lastVal=" + lastNode.val + " val=" + node.val);
                            return false;
                        }
                    } else {
                        if (c >= 0) {
                            //System.out.println("<= lastVal=" + lastNode.val + " val=" + node.val);
                            return false;
                        }
                    }
                }
                size--;
                lastNode = node;
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isEvenOddTree(
            new TreeNode(
                1,
                new TreeNode(
                    10,
                    new TreeNode(3, new TreeNode(12), new TreeNode(8)),
                    null
                ),
                new TreeNode(
                    4,
                    new TreeNode(7, new TreeNode(6), null),
                    new TreeNode(9, null, new TreeNode(2))
                )
            )
        ));
    }
}

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
