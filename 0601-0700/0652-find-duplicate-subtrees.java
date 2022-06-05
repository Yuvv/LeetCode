import java.util.*;

/*
 * 0652-find-duplicate-subtrees.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/05
 */
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, TreeNode> nodeMap = new HashMap<>();
        dfs(root, map, nodeMap);

        List<TreeNode> resList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                resList.add(nodeMap.get(entry.getKey()));
            }
        }
        return resList;
    }

    private String dfs(TreeNode node, Map<String, Integer> map, Map<String, TreeNode> nodeMap) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        // left
        String leftStr = dfs(node.left, map, nodeMap);
        sb.append(",(").append(leftStr).append(")");
        // right
        String rightStr = dfs(node.right, map, nodeMap);
        sb.append(",(").append(rightStr).append(")");

        String res = sb.toString();
        map.put(res, map.getOrDefault(res, 0) + 1);
        nodeMap.put(res, node);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[2,4],[4]]
        System.out.println(s.findDuplicateSubtrees(
            new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4))
            )
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

    @Override
    public String toString() {
        return "TreeNode(" + val + ", left=" + left + ", right=" + right + ")";
    }
}
