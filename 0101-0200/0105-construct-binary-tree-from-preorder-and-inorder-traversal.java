/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int indexOf(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder: first one is root
        // inorder: root's left is left sub-tree, root's right is right sub-tree

        if (inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int[] nextPreorder = Arrays.copyOfRange(preorder, 1, preorder.length);
        int midIndex = indexOf(inorder, preorder[0]);
        int [] nextLeftInOrder = Arrays.copyOfRange(inorder, 0, midIndex);
        int [] nextRightInOrder = Arrays.copyOfRange(inorder, midIndex + 1, inorder.length);
        root.left = buildTree(nextPreorder, nextLeftInOrder);
        nextPreorder = Arrays.copyOfRange(preorder, midIndex + 1, preorder.length);
        root.right = buildTree(nextPreorder, nextRightInOrder);

        return root;
    }
}