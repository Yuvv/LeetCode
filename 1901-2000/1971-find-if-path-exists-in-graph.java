import java.util.*;

/**
 * 1971-find-if-path-exists-in-graph.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/04/21
 */
public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] union = new int[n];
        for (int i = 1; i < n; i++) {
            union[i] = i;
        }
        for (int[] edge : edges) {
            int a = UnionFind(union, edge[0]);
            int b = UnionFind(union, edge[1]);
            int u = Math.min(a, b);
            union[a] = u;
            union[b] = u;
            union[edge[0]] = u;
            union[edge[1]] = u;
        }
        return UnionFind(union, source) == UnionFind(union, destination);
    }

    private int UnionFind(int[] union, int u) {
        while (union[u] != u) {
            u = union[u];
        }
        return u;
    }

    public boolean validPath_dfs(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(n);
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        return dfs(graph, new boolean[n], new boolean[n], source, destination);
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, boolean[] seen, boolean[] checked, int source, int dest) {
        if (source == dest) {
            checked[source] = true;
            return true;
        }
        if (!graph.containsKey(source)) {
            checked[source] = true;
            return false;
        }
        if (seen[source]) {
            return false;
        }
        if (checked[source]) {
            return false;
        }
        seen[source] = true;
        for (Integer next : graph.get(source)) {
            if (dfs(graph, seen, checked, next, dest)) {
                checked[source] = true;
                return true;
            }
        }
        seen[source] = false;
        checked[source] = true;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.validPath(
            3,
            new int[][] {{0,1}, {1,2}, {2,0}},
            0, 2
        ));
        // false
        System.out.println(s.validPath(
            6,
            new int[][] {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}},
            0, 5
        ));
    }
}