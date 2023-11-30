import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * 0508-most-frequent-subtree-sum
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/30
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res.clear();
                res.add(entry.getKey());
            } else if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode node, Map<Integer, Integer> fcntMap) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, fcntMap);
        int right = dfs(node.right, fcntMap);
        int sum = left + right + node.val;
        fcntMap.put(sum, fcntMap.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,-3,4]
        System.out.println(java.util.Arrays.toString(
                s.findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-3)))));
        // [2]
        System.out.println(java.util.Arrays.toString(
                s.findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-5)))));
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
