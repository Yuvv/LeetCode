import java.util.*;


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
 * 0222-count-complete-tree-nodes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/24
 */
public class Solution {
    public int countNodes(TreeNode root) {
        int leftLevel = 0, rightLevel = 0;
        TreeNode node = root;
        while (node != null) {
            leftLevel += 1;
            node = node.left;
        }
        if (leftLevel == 0) {
            return 0;
        }
        node = root;
        while (node != null) {
            rightLevel += 1;
            node = node.right;
        }
        if (leftLevel == rightLevel) {
            return ((int) Math.pow(2, leftLevel)) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countNodes(new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null)
        )));
        // 0
        System.out.println(s.countNodes(null));
        // 1
        System.out.println(s.countNodes(new TreeNode(1)));
    }
}