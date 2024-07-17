import java.util.*;

/**
 * 1110-delete-nodes-and-return-forest.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/17
 */
public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<TreeNode> resList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int d : to_delete) {
            set.add(d);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            if (set.contains(node.val)) { // contains root
                stack.push(node.left);
                stack.push(node.right);
                continue;
            }
            resList.add(node);
            // travel leaf
            LinkedList<TreeNode> tempStack = new LinkedList<>();
            tempStack.add(node);
            while (!tempStack.isEmpty()) {
                TreeNode tempNode = tempStack.pop();
                if (tempNode.left != null) {
                    if (set.contains(tempNode.left.val)) {
                        stack.push(tempNode.left.left);
                        stack.push(tempNode.left.right);
                        tempNode.left = null;
                    } else {
                        tempStack.push(tempNode.left);
                    }
                }
                if (tempNode.right != null) {
                    if (set.contains(tempNode.right.val)) {
                        stack.push(tempNode.right.left);
                        stack.push(tempNode.right.right);
                        tempNode.right = null;
                    } else {
                        tempStack.push(tempNode.right);
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,2,null,4], [6], [7]]
        System.out.println(s.delNodes(
            new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))),
            new int[]{3,5}
        ));
        // [[1,2,4]]
        System.out.println(s.delNodes(
            new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(4)),
            new int[] {3}
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


