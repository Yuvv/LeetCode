import java.util.*;

/*
 * 0987-vertical-order-traversal-of-a-binary-tree.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/10
 */
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        LinkedList<LeveledTreeNode> queue = new LinkedList<>();
        queue.add(new LeveledTreeNode(0, 0, root));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            LeveledTreeNode node = queue.poll();
            treeMap.computeIfAbsent(node.col, k -> new TreeMap<>())
                    .computeIfAbsent(node.row, k -> new PriorityQueue<>())
                    .add(node.node.val);
            if (node.node.left != null) {
                queue.add(new LeveledTreeNode(node.row + 1, node.col - 1, node.node.left));
            }
            if (node.node.right != null) {
                queue.add(new LeveledTreeNode(node.row + 1, node.col + 1, node.node.right));
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : treeMap.entrySet()) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> innerEntry : entry.getValue().entrySet()) {
                PriorityQueue<Integer> heap = innerEntry.getValue();
                while (!heap.isEmpty()) {
                    list.add(heap.poll());
                }
            }
            resList.add(list);
        }
        return resList;
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

class LeveledTreeNode {
    int row;
    int col;
    TreeNode node;

    public LeveledTreeNode(int row, int col, TreeNode node) {
        this.row = row;
        this.col = col;
        this.node = node;
    }
}
