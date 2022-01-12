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
 * 0701-insert-into-a-binary-search-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/12
 */
 public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode node = root;
        while (true) {
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            } else if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,2,7,1,3,5]
        System.out.println(s.insertIntoBST(
            new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)),
            5
        ));
        // [40,20,60,10,30,50,70,null,null,25]
        System.out.println(s.insertIntoBST(
            new TreeNode(
                40,
                new TreeNode(20, new TreeNode(10), new TreeNode(30)),
                new TreeNode(60, new TreeNode(50), new TreeNode(70))
            ),
            25
        ));
    }
}