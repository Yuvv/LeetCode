import java.util.LinkedList;


/**
 * 1026-maximum-difference-between-node-and-ancestor
 *
 * @date 2024/01/11
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        } 
        LinkedList<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root.val, root.val, root});
        int max = 0;
        while (!queue.isEmpty()) {
            Object[] item = queue.poll();
            TreeNode node = (TreeNode) item[2];
            int lMax = Math.max((int)item[0], node.val);
            int lMin = Math.min((int)item[1], node.val);
            max = Math.max(max, lMax-lMin);
            if (node.left != null) {
                queue.add(new Object[]{lMax, lMin, node.left});
            }
            if (node.right != null) {
                queue.add(new Object[]{lMax, lMin, node.right});
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.maxAncestorDiff(
                    new TreeNode(8,
                        new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
                        new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)))
                    ));
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

