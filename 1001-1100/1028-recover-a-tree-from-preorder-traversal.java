import java.util.LinkedList;

/*
 * 1028-recover-a-tree-from-preorder-traversal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/23
 */
public class Solution {
    public TreeNode recoverFromPreorder(String s) {
        LinkedList<WrappedTreeNode> stack = new LinkedList<>();
        int fromIdx = 0;
        while (fromIdx < s.length()) {
            int level = 0;
            while (fromIdx < s.length() && s.charAt(fromIdx) == '-') {
                level++;
                fromIdx++;
            }
            int valBeginIdx = fromIdx;
            while (fromIdx < s.length() && s.charAt(fromIdx) != '-') {
                fromIdx++;
            }
            int val = Integer.parseInt(s.substring(valBeginIdx, fromIdx));
            TreeNode node = new TreeNode(val);
            while (!stack.isEmpty() && stack.peek().level >= level) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(new WrappedTreeNode(node, level));
            } else {
                if (stack.peek().node.left == null) {
                    stack.peek().node.left = node;
                } else {
                    stack.peek().node.right = node;
                }
                stack.push(new WrappedTreeNode(node, level));
            }
        }
        return stack.peekLast().node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,5,3,4,6,7]
        System.out.println(s.recoverFromPreorder("1-2--3--4-5--6--7"));
    }
}

class WrappedTreeNode {
    TreeNode node;
    int level;

    public WrappedTreeNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
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

    @Override
    public String toString() {
        return "TN(val=" + val + ", left=" + left + ", right=" + right + ")";
    }
}
