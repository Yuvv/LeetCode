import java.util.LinkedList;
/**
 * 0993-cousins-in-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/21
 */
public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.val == x) {
                    xFound = true;
                }
                if (node.val == y) {
                    yFound = true;
                }
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (xFound && yFound) {
                return true;
            } else if (xFound || yFound) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.isCousins(
            new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3)),
            4, 3));
        // true
        System.out.println(s.isCousins(
            new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5))),
            5, 4));
        // false
        System.out.println(s.isCousins(
            new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3)),
            5, 4));
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
