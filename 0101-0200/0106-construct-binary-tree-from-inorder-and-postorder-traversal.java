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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder: root's left is left sub-tree, root's right is right sub-tree
        // postorder: last one is root

        if (inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int midIndex = indexOf(inorder, root.val);
        int [] nextLeftInOrder = Arrays.copyOfRange(inorder, 0, midIndex);
        int [] nextRightInOrder = Arrays.copyOfRange(inorder, midIndex + 1, inorder.length);
        int[] nextPostOrder = Arrays.copyOfRange(postorder, 0, midIndex);
        root.left = buildTree(nextLeftInOrder, nextPostOrder);
        nextPostOrder = Arrays.copyOfRange(postorder, midIndex, postorder.length - 1);
        root.right = buildTree(nextRightInOrder, nextPostOrder);

        return root;
    }
}