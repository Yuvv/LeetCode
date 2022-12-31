import java.util.*;

/*
 * 0958-check-completeness-of-a-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/12/31
 */
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean levelFull = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    if (!levelFull) {
                        return false;
                    }
                    queue.addLast(node.left);
                } else if (node.right != null) {
                    // fast return
                    return false;
                } else {
                    levelFull = false;
                }
                if (node.right != null) {
                    if (!levelFull) {
                        return false;
                    }
                    queue.addLast(node.right);
                } else {
                    levelFull = false;
                }
                levelSize--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isCompleteTree(
            new TreeNode(
                1,
                new TreeNode(
                    2, new TreeNode(4), new TreeNode(5)
                ),
                new TreeNode(
                    3, new TreeNode(6), null
                )
            )
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
