import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 0655-print-binary-tree
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/30
 */
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        int nCol = (int) Math.pow(2, depth) - 1;
        List<List<String>> res = new ArrayList<>(depth);
        for (int i = 0; i < depth; i++) {
            List<String> x = new ArrayList<>(nCol);
            for (int j = 0; j < nCol; j++) {
                x.add("");
            }
            res.add(x);
        }
        fill(res, root, 0, 0, nCol - 1);
        return res;
    }

    private void fill(List<List<String>> res, TreeNode node, int row, int col0, int col1) {
        if (node == null) {
            return;
        }
        int pos = (col0 + col1) / 2;
        res.get(row).set(pos, "" + node.val);

        fill(res, node.left, row + 1, col0, pos - 1);
        fill(res, node.right, row + 1, pos + 1, col1);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [["","1",""], ["2","",""]]
        System.out.println(s.printTree(
                new TreeNode(1, new TreeNode(2), null)));
        // [["","","","1","","",""], ["","2","","","","3",""],["","","4","","","",""]]
        System.out.println(s.printTree(
                new TreeNode(1,
                        new TreeNode(2, null, new TreeNode(4)),
                        new TreeNode(3))));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
