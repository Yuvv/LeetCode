/**
 * 2331-evaluate-boolean-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/27
 */
public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val > 0;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else { // 3-AND
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.evaluateTree(
            new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3, new TreeNode(0), new TreeNode(1))
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
