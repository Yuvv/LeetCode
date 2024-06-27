import java.util.*;

/**
 * 1530-number-of-good-leaf-nodes-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/26
 */
public class Solution {
    public int countPairs(TreeNode root, int distance) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Map<Integer, Integer> res = dfsCountPairs(root, distance, treeMap);
        return treeMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    private Map<Integer, Integer> dfsCountPairs(TreeNode root, int dis, TreeMap<Integer, Integer> treeMap) {
        Map<Integer, Integer> map = new HashMap<>();
        if (root == null) {
            return map;
        }
        if (root.left == null && root.right == null) {
            map.put(0, 1);
            return map;
        }
        Map<Integer, Integer> lmap = dfsCountPairs(root.left, dis, treeMap);
        Map<Integer, Integer> rmap = dfsCountPairs(root.right, dis, treeMap);
        for (Map.Entry<Integer, Integer> entry : lmap.entrySet()) {
            int lh = entry.getKey() + 1;
            for (int i = 0; i < dis - lh; i++) {
                int h = i + 1 + lh;
                if (rmap.containsKey(i)) {
                    treeMap.put(h, treeMap.getOrDefault(h, 0) + rmap.get(i) * entry.getValue());
                }
            }
            if (lh < dis) {
                map.put(lh, map.getOrDefault(lh, 0) + entry.getValue());
            }
        }
        for (Map.Entry<Integer, Integer> entry : rmap.entrySet()) {
            int rh = entry.getKey() + 1;
            if (rh < dis) {
                map.put(rh, map.getOrDefault(rh, 0) + entry.getValue());
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
         // 3
        System.out.println(s.countPairs(
                new TreeNode(15,
                        new TreeNode(66, new TreeNode(97, null, new TreeNode(54)), new TreeNode(60, null, new TreeNode(49, null, new TreeNode(90)))),
                        new TreeNode(55, new TreeNode(12, null, new TreeNode(9)), new TreeNode(56))),
                5
        ));
        // 1
        System.out.println(s.countPairs(
            new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3)),
            3
        ));
        // 2
        System.out.println(s.countPairs(
            new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))),
            3
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
