/*
 * 2265-count-nodes-equal-to-average-of-subtree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/13
 */
public class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] countAndSumAndRes = countAvgOfSubtree(root);

        return countAndSumAndRes[2];
    }

    // return (count, sum, res)
    public int[] countAvgOfSubtree(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0, 0};
        }
        int[] left = countAvgOfSubtree(root.left);
        int[] right = countAvgOfSubtree(root.right);
        int sum = left[1] + right[1] + root.val;
        int count = left[0] + right[0] + 1;
        int res = left[2] + right[2];

        if (sum / count == root.val) {
            res++;
        }
        return new int[] {count, sum, res};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.averageOfSubtree(new TreeNode(1)));
        //
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
