/**
 * 1123-lowest-common-ancestor-of-deepest-leaves.java
 *
 * this question is the same as 865-smallest-subtree-with-all-the-deepest-nodes
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/04
 */

public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Object[] res = lca(root, 0);
        return (TreeNode)(res[0]);
    }

    private Object[] lca(TreeNode node, int level) {
        if (node == null) {
            return new Object[]{null, level};
        }
        Object[] left = lca(node.left, level + 1);
        Object[] right = lca(node.right, level + 1);
        if (left[0] == null && right[0] == null) {
            // current node is leaf
            return new Object[]{node, level};
        } else if (left[0] == null || ((Integer)left[1]).compareTo((Integer)(right[1])) < 0) {
            // left is null
            return right;
        } else if (right[0] == null || ((Integer)left[1]).compareTo((Integer)(right[1])) > 0) {
            // right is null
            return left;
        } else {
            // level equals, current node is common ancestor
            return new Object[]{node, left[1]};
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,7,4]
        System.out.println(s.lcaDeepestLeaves(
            new TreeNode(3,
                new TreeNode(5,
                    new TreeNode(6),
                    new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4))),
                new TreeNode(1,
                    new TreeNode(0),
                    new TreeNode(8)))
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
