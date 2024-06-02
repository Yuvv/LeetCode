/**
 * 1325-delete-leaves-with-a-given-value.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/02
 */
public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (remove(root, target)) {
            return null;
        }
        return root;
    }

    public boolean remove(TreeNode node, int target) {
        if (node == null) {
            return true;
        }
        boolean left = node.left == null || remove(node.left, target);
        if (left) {
            node.left = null;
        }
        boolean right = node.right == null || remove(node.right, target);
        if (right) {
            node.right = null;
        }
        return left && right && node.val == target;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,null,3,null,4]
        System.out.println(s.removeLeafNodes(
            new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(3, new TreeNode(2), new TreeNode(4))),
            2
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
    @Override
    public String toString() {
        return "TreeNode(val=" + val + ", left=" + left + ", right=" + right + ")";
    }
}
