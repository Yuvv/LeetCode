import java.util.*;

/*
 * 0865-smallest-subtree-with-all-the-deepest-nodes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/29
 */
public class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(root.val, -1);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> lastLevelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            lastLevelList.clear();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                nodeMap.put(node.val, node);
                if (node.left != null) {
                    parentMap.put(node.left.val, node.val);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right.val, node.val);
                    queue.add(node.right);
                }
                if (node.left == null && node.right == null) {
                    // maybe last level
                    lastLevelList.add(node.val);
                }
                size--;
            }
        }
        Set<Integer> parentSet = new HashSet<>(lastLevelList);
        while (parentSet.size() > 1) {
            Set<Integer> set = new HashSet<>();
            for (Integer v : parentSet) {
                set.add(parentMap.get(v));
            }
            parentSet = set;
        }
        return nodeMap.get(parentSet.iterator().next());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1]
        System.out.println(s.subtreeWithAllDeepest(new TreeNode(1)));
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
