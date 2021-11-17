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

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int val = root.val;
        while (!queue.isEmpty()) {
            val = queue.peek().val;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.findBottomLeftValue(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }
}