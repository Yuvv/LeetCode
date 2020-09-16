import java.util.*;

/*
 * 0236-lowest-common-ancestor-of-a-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/09/16
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);

        while (stack.peek() != null) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> pParentNodeSet = new HashSet<>();
        while (p != null) {
            pParentNodeSet.add(p);
            p = parentMap.get(p);
        }
        while (q != null) {
            if (pParentNodeSet.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof TreeNode) {
            return ((TreeNode) obj).val == val;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TreeNode[" + val + "]";
    }
}