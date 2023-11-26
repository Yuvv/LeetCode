import java.util.*;

/**
 * 2415-reverse-odd-levels-of-binary-tree
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/26
 */
public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nextLevel = new ArrayList<>(2 * size);
            for (TreeNode node : queue) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            int i = nextLevel.size() - 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                if (i >= 0) {
                    node.left = nextLevel.get(i);
                    i--;
                }
                if (i >= 0) {
                    node.right = nextLevel.get(i);
                    i--;
                }
            }
            int j;
            for (i = 0, j = nextLevel.size() - 1; i < j; i++, j--) {
                TreeNode left = nextLevel.get(i);
                TreeNode right = nextLevel.get(j);
                // switch left
                TreeNode node = left.left;
                left.left = right.left;
                right.left = node;
                // switch right
                node = left.right;
                left.right = right.right;
                right.right = node;
            }

            for (i = nextLevel.size() - 1; i >= 0; i--) {
                TreeNode node = nextLevel.get(i);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,5,3,13,21,34]
        System.out.println(s.reverseOddLevels(
                new TreeNode(2,
                        new TreeNode(3, new TreeNode(8), new TreeNode(13)),
                        new TreeNode(5, new TreeNode(21), new TreeNode(34)))));
        // [7,11,13]
        System.out.println(s.reverseOddLevels(
                new TreeNode(7, new TreeNode(13), new TreeNode(11))));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode(val=" + val + ", left=" + left + ", right=" + right + ")";
    }
}
