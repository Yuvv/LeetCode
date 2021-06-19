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
 * 0173-binary-search-tree-iterator.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/19
 */
public class BSTIterator {

    private LinkedList<TreeNode> toProcessQueue;
    private LinkedList<TreeNode> leftProcessedQueue;

    public BSTIterator(TreeNode root) {
        toProcessQueue = new LinkedList<>();
        leftProcessedQueue = new LinkedList<>();
        if (root != null) {
            toProcessQueue.add(root);
        }
    }

    public int next() {
        while (!toProcessQueue.isEmpty()) {
            TreeNode node = toProcessQueue.pollFirst();
            leftProcessedQueue.addFirst(node);
            if (node.left != null) {
                toProcessQueue.addFirst(node.left);
            }
        }

        TreeNode node = leftProcessedQueue.pollFirst();
        if (node.right != null) {
            toProcessQueue.addFirst(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !leftProcessedQueue.isEmpty() || !toProcessQueue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
