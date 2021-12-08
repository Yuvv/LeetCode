
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
        return "TreeNode(" + val + ", left=" + left + ", right=" + right + ")";
    }
}

/*
 * 0897-increasing-order-search-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/08
 */
public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] res = makeIncreasingBst(root);
        return res[0];
    }

    public TreeNode[] makeIncreasingBst(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode head = node;
        TreeNode tail = node;
        if (node.left != null) {
            TreeNode[] res = makeIncreasingBst(node.left);
            head = res[0];
            res[1].right = node;
        }
        node.left = null;
        if (node.right != null) {
            TreeNode[] res = makeIncreasingBst(node.right);
            node.right = res[0];
            tail = res[1];
        }
        return new TreeNode[] {head, tail};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
        System.out.println(s.increasingBST(new TreeNode(
            5,
            new TreeNode(
                3,
                new TreeNode(2, new TreeNode(1), null),
                new TreeNode(4)
            ),
            new TreeNode(
                6,
                null,
                new TreeNode(8, new TreeNode(7), new TreeNode(9))
            )
        )));
        // [1,null,5,nul,7]
        System.out.println(s.increasingBST(new TreeNode(
            5,
            new TreeNode(1),
            new TreeNode(7)
        )));
    }
}