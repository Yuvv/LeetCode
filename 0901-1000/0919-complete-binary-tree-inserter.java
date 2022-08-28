import java.util.*;

/*
 * 0919-complete-binary-tree-inserter.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/28
 */
public class CBTInserter {

    private TreeNode root;
    private LinkedList<TreeNode> notFullNodes;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.notFullNodes = new LinkedList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node.left == null || node.right == null) {
                notFullNodes.addLast(node);
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode parent = notFullNodes.peek();
        if (parent.left == null) {
            parent.left = node;
        } else if (parent.right == null) {
            parent.right = node;
        }
        if (parent.left != null && parent.right != null) {
            notFullNodes.pollFirst();
        }
        notFullNodes.addLast(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return this.root;
    }

    public static void main(String[] args) {
        CBTInserter cbt = new CBTInserter(new TreeNode(1, new TreeNode(2), null));
        // 1
        System.out.println(cbt.insert(3));
        // 2
        System.out.println(cbt.insert(4));
        // [1,2,3,4]
        System.out.println(cbt.get_root());
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
