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
 * 0102-binary-tree-level-order-traversal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/12/08
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = stack.size();
            while (size > 0) {
                TreeNode node = stack.pop();
                levelList.add(node.val);
                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
                size--;
            }
            res.add(levelList);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // null -> []
        System.out.println(s.levelOrder(null));
        // [1] -> [1]
        System.out.println(s.levelOrder(new TreeNode(1)));
    }
}