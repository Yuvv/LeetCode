import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) { val = x; this.left = left; this.right = right; }
}

/*
 * 0979-distribute-coins-in-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/08
 */
public class Solution {
    private int res;
    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        res += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.distributeCoins(new TreeNode(
            1,
            new TreeNode(0, null, new TreeNode(3)),
            new TreeNode(0)
        )));
        // 2
        System.out.println(s.distributeCoins(new TreeNode(
            1,
            new TreeNode(0),
            new TreeNode(2)
        )));
        // 3
        System.out.println(s.distributeCoins(new TreeNode(
            0,
            new TreeNode(3),
            new TreeNode(0)
        )));
        // 2
        System.out.println(s.distributeCoins(new TreeNode(
            3,
            new TreeNode(0),
            new TreeNode(0)
        )));
    }
}