
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

public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // get root node
        while (root != null) {
            if (root.val < low) {
                root = root.right;
            } else if (root.val > high) {
                root = root.left;
            } else {
                break;
            }
        }
        if (root == null) {
            return null;
        }
        // left
        root.left = trimBST(root.left, low, high);
        // right
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,null,2]
        System.out.println(s.trimBST(
            new TreeNode(1, new TreeNode(0), new TreeNode(2)),
            1, 2
        ));
        // [1,null,2]
        System.out.println(s.trimBST(
            new TreeNode(1, new TreeNode(0), new TreeNode(2)),
            1, 3
        ));
    }
}