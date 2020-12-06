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
 * 0094-binary-tree-inorder-traversal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/11/24
 */
public class Solution {
    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stackLeft = new LinkedList<>();
        LinkedList<TreeNode> stackMid = new LinkedList<>();
        LinkedList<TreeNode> stackRight = new LinkedList<>();
        // 初始化
        stackLeft.push(root.left);
        stackMid.push(root);
        stackRight.push(root.right);
        while (!stackLeft.isEmpty() || !stackMid.isEmpty() || !stackRight.isEmpty()) {
            // 左子
            while (!stackLeft.isEmpty()) {
                TreeNode curNode = stackLeft.poll();
                if (curNode == null) {
                    continue;
                } else if (curNode.left == null && curNode.right == null) {
                    result.add(curNode.val);
                } else {
                    stackLeft.push(curNode.left);
                    stackMid.push(curNode);
                    stackRight.push(curNode.right);
                }
            }
            // 中子
            if (stackLeft.isEmpty() && !stackMid.isEmpty()) {
                TreeNode curNode = stackMid.poll();
                if (curNode != null) {
                    result.add(curNode.val);
                }
            }
            // 右子
            if (!stackRight.isEmpty()) {
                TreeNode curNode = stackRight.poll();
                if (curNode == null) {
                    continue;
                } else if (curNode.left == null && curNode.right == null) {
                    result.add(curNode.val);
                } else {
                    stackLeft.push(curNode.left);
                    stackMid.push(curNode);
                    stackRight.push(curNode.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [null] -> []
        TreeNode head = null;
        System.out.println(s.inorderTraversal(head));
        // [1] -> [1]
        head = new TreeNode(1);
        System.out.println(s.inorderTraversal(head));
        // [1,null,2,3] -> [1,3,2]
        head = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(s.inorderTraversal(head));
    }

    /**
     * another simple way
     */
    public List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * Morris Traversal
     */
    public List < Integer > inorderTraversal3(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}