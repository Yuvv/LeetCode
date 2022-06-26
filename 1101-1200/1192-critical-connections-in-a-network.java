import java.util.*;

/*
 * 1192-critical-connections-in-a-network.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/18
 */
public class Solution {
    /**
     * Tarjan's Algorithm - find bridge
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : connections) {
            graph.computeIfAbsent(edge.get(0), k -> new HashSet<>()).add(edge.get(1));
            graph.computeIfAbsent(edge.get(1), k -> new HashSet<>()).add(edge.get(0));
        }

        boolean[] visited = new boolean[n];
        // `values[][0]` means depth, `values[][1]` means lowpoint
        int[][] values = new int[n][2];

        List<List<Integer>> resList = new ArrayList<>();
        dfs(-1, 0, 0, graph, visited, values, resList);
        return resList;
    }

    private void dfs(int parent, int node, int depth,
                     Map<Integer, Set<Integer>> graph,
                     boolean[] visited, int[][] values,
                     List<List<Integer>> resList) {
        visited[node] = true;
        values[node][0] = depth;
        values[node][1] = depth;

        for (int next : graph.get(node)) {
            if (next == parent) {
                continue;
            }
            if (visited[next]) {
                values[node][1] = Math.min(values[node][1], values[next][0]);
            } else {
                dfs(node, next, depth + 1, graph, visited, values, resList);
                if (values[next][1] > values[node][0]) {
                    resList.add(Arrays.asList(node, next));
                }
                values[node][1] = Math.min(values[node][1], values[next][1]);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,3]]
        System.out.println(s.criticalConnections(
            4,
            Arrays.asList(Arrays.asList(0,1), Arrays.asList(1,2), Arrays.asList(2,0), Arrays.asList(1,3))
        ));
        // [[0,1]]
        System.out.println(s.criticalConnections(
            2,
            Collections.singletonList(Arrays.asList(0,1))
        ));
    }
}
/**
14
[[0, 1], [0, 2], [1, 3], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7], [6, 8], [6, 13], [8, 10], [8, 9], [10, 11], [11, 12], [11, 13], [12, 13]]
 */