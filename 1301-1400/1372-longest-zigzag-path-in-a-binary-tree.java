/**
 * 1372-longest-zigzag-path-in-a-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/18
 */
public class Solution {
    public int longestZigZag(TreeNode root) {
        return Math.max(
            dfsZigZag(root, 0, true),
            dfsZigZag(root, 0, false)
        );
    }

    public int dfsZigZag(TreeNode root, int maxlen, boolean isLeft) {
        if (isLeft) {
            if (root.left != null) {
                maxlen++;
                maxlen = Math.max(maxlen, dfsZigZag(root.left, maxlen, false));
                maxlen = Math.max(maxlen, dfsZigZag(root.left, 0, true)); // restart
            }
        } else {
            if (root.right != null) {
                maxlen++;
                maxlen = Math.max(maxlen, dfsZigZag(root.right, maxlen, true));
                maxlen = Math.max(maxlen, dfsZigZag(root.right, 0, false)); // restart
            }
        }
        return maxlen;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.longestZigZag(
            new TreeNode(
                1,
                null,
                new TreeNode(
                    1,
                    new TreeNode(1),
                    new TreeNode(
                        1,
                        new TreeNode(
                            1,
                            null,
                            new TreeNode(1, null, new TreeNode(1))),
                        new TreeNode(1))))
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
