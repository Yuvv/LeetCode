import java.util.*;
/**
 * 3372-maximize-the-number-of-target-nodes-after-connecting-trees-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/28
 */
public class Solution {
    private Map<Integer, Set<Integer>> buildTree(int[][] edges) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        return tree;
    }

    private int dfs(int node, Map<Integer, Set<Integer>> tree, int k, Set<Integer> seen) {
        if (seen.contains(node)) {
            return 0; // already counted
        }
        if (k <= 0) {
            return 0; // no more targets to count
        }
        seen.add(node);
        for (int child : tree.getOrDefault(node, new HashSet<>())) {
            dfs(child, tree, k - 1, seen);
        }
        return seen.size(); // return the size of seen nodes
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, Set<Integer>> tree1 = this.buildTree(edges1);
        Map<Integer, Set<Integer>> tree2 = this.buildTree(edges2);
        int[] result = new int[edges1.length + 1];

        Set<Integer> seen = new HashSet<>();
        // find largest N in edges2
        int maxCnt2 = 0;
        for (int i = 0; i < edges2.length; i++) {
            seen.clear(); // reset seen for each node
            int cnt = this.dfs(i, tree2, k-1, seen);
            System.out.println("Node " + i + " in tree2 can reach " + cnt + " nodes with k=" + k);
            maxCnt2 = Math.max(maxCnt2, cnt);
        }
        for (int i = 0; i < edges1.length; i++) {
            seen.clear(); // reset seen for each node
            int cnt1 = this.dfs(i, tree1, k, seen);
            System.out.println("Node " + i + " in tree1 can reach " + cnt1 + " nodes with k=" + k);
            result[i] = cnt1 + maxCnt2 + 1; // combine counts from both trees
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [9,7,9,8,8]
        System.out.println(Arrays.toString(s.maxTargetNodes(
            new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}},
            new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}},
            2
        )));
        // [6,3,3,3,3]
        System.out.println(Arrays.toString(s.maxTargetNodes(
            new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}},
            new int[][]{{0, 1}, {1, 2}, {2, 3}},
            1
        )));
    }
}