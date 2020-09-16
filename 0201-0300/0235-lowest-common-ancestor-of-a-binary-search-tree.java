
/*
 * 0235-lowest-common-ancestor-of-a-binary-search-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/09/16
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode n = p;
            p = q;
            q = n;
        }
        while (root != null) {
            if (root.val >= p.val && root.val <= q.val) {
                return root;
            } if (root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            }
        }
        return null;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof TreeNode) {
            return ((TreeNode) obj).val == val;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TreeNode[" + val + "]";
    }
}