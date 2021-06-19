import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


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
 * 0199-binary-tree-right-side-view.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/19
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.peekFirst();
            result.add(node.val);
            int curCount = 0;
            while (count > 0) {
                node = queue.pop();
                if (node.right != null) {
                    queue.add(node.right);
                    curCount++;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    curCount++;
                }
                count--;
            }
            count = curCount;
        }
        return result;
    }
}