import java.util.*;
/*
 * 1379-find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/24
 */
public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(cloned);
        // since value is `unique`
        while (!queue.isEmpty() && queue.peek().val != target.val) {
            TreeNode node = queue.pollFirst();
            if (node.left != null) {
                if (node.left.val == target.val) {
                    return node.left;
                }
                queue.addLast(node.left);
            }
            if (node.right != null) {
                if (node.right.val == target.val) {
                    return node.right;
                }
                queue.addLast(node.right);
            }
        }
        return queue.peek();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
