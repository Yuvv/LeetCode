import java.util.*;
import java.util.stream.Collectors;

/**
 * 0310-minimum-height-trees.java
 *
 * @date 2024/4/23
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        LinkedList<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 1) {
                leaves.add(i);
            }
        }
        while (graph.size() > 2) {  // at most 2 nodes can be left
            int size = leaves.size();
            while (size-- > 0) {  // remove all leaves
                Integer leaf = leaves.pollFirst();
                graph.get(leaf).forEach(neighbor -> {
                    graph.get(neighbor).remove(leaf);
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 1) {
                        leaves.addLast(neighbor);
                    }
                });
                graph.remove(leaf);
            }
        }
        return new ArrayList<>(leaves);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1]
        System.out.println(s.findMinHeightTrees(4, new int[][]{{1,0}, {1,2}, {1,3}}));
        // [3,4]
        System.out.println(s.findMinHeightTrees(6, new int[][]{
            {3,0}, {3,1}, {3,2}, {3,4}, {5,4}
        }));
    }
}
