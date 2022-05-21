import java.util.*;

/*
 * 1302-deepest-leaves-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/24
 */
public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        // 层级遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 每次都重置 sum，计算当前层级的和，那么遍历到最后一个层级就是最终结果
            sum = 0;
            while (size > 0) {
                TreeNode node = queue.pollFirst();
                sum += node.val;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                size--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.deepestLeavesSum(
            new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(4))
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
