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
 * 0632-add-one-row-to-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/03/25
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        int curRow = 1;
        if (curRow == depth) {
            return new TreeNode(val, root, null);
        }
        Map<Integer, List<TreeNode>> nodeRowMapByDepth = new HashMap<>(8);
        nodeRowMapByDepth.put(curRow, Arrays.asList(root));
        while (curRow != depth - 1) {
            List<TreeNode> nodes = nodeRowMapByDepth.remove(curRow);
            List<TreeNode> nextNodes = new ArrayList<>(nodes.size() * 2);
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    nextNodes.add(node.left);
                }
                if (node.right != null) {
                    nextNodes.add(node.right);
                }
            }
            curRow++;
            nodeRowMapByDepth.put(curRow, nextNodes);
        }
        List<TreeNode> nodes = nodeRowMapByDepth.remove(curRow);
        for (TreeNode node : nodes) {
            TreeNode originLeft = node.left;
            TreeNode originRight = node.right;
            node.left = new TreeNode(val, originLeft, null);
            node.right = new TreeNode(val, null, originRight);
        }

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.addOneRow(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 2, 2));
    }
}