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
 * 1008-construct-binary-search-tree-from-preorder-traversal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/13
 */
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (stack.peek() != null && preorder[i] < stack.peek().val) {
                stack.peek().left = node;
                stack.push(node);
            } else {
                TreeNode peekNode = stack.pop();
                while (stack.peek() != null && stack.peek().val < preorder[i]) {
                    peekNode = stack.pop();
                }
                peekNode.right = node;
                stack.push(node);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [8,5,10,1,7,null,12]
        System.out.println(s.bstFromPreorder(new int[] {8,5,1,7,10,12}));
        // [1,null,3]
        System.out.println(s.bstFromPreorder(new int[] {1, 3}));
        // [15,13,18,12]
        System.out.println(s.bstFromPreorder(new int[] {15, 13, 12, 18}));
    }
}