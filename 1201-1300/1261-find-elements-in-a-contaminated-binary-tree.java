import java.util.*;
/*
 * 1261-find-elements-in-a-contaminated-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/11
 */
public class FindElements {

    private TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        root.val = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                node.left.val = 2 * node.val + 1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.val = 2 * node.val + 2;
                queue.add(node.right);
            }
        }
    }

    public boolean find(int target) {
        if (target < 0 || root == null) {
            return false;
        }
        TreeNode node = root;
        List<Boolean> path = new ArrayList<>();
        while (target > 0) {
            if (target%2 == 0) {
                path.add(true);
                target = (target - 2) / 2;
            } else {
                path.add(false);
                target = (target - 1) / 2;
            }
        }
        for (int i = path.size() - 1; i >= 0; i--) {
            if (path.get(i)) {  // even
                if (node.right == null) {
                    return false;
                }
                node = node.right;
            } else { // odd
                if (node.left == null) {
                    return false;
                }
                node = node.left;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindElements fe = new FindElements(new TreeNode(-1, null, new TreeNode(-2)));
        // false
        System.out.println(fe.find(1));
        // true
        System.out.println(fe.find(2));
    }
}

// AC but slow
class FindElementsOld {

    private TreeNode root;

    public FindElementsOld(TreeNode root) {
        this.root = root;

        root.val = 0;
        recover(root.left, 0, true);
        recover(root.right, 0, false);
    }

    private void recover(TreeNode root, int parentVal, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (isLeft) {
            root.val = 2 * parentVal + 1;
        } else {
            root.val = 2 * parentVal + 2;
        }
        recover(root.left, root.val, true);
        recover(root.right, root.val, false);
    }

    public boolean find(int target) {
        return find(root, target);
    }

    private boolean find(TreeNode node, int target) {
        if (node == null || node.val > target) {
            return false;
        }
        if (node.val == target) {
            return true;
        }
        boolean res = false;
        if (node.left != null && target >= node.left.val) {
            res = find(node.left, target);
        }
        if (!res && node.right != null && target >= node.right.val) {
            res = find(node.right, target);
        }
        return res;
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
