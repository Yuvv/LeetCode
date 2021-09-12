import java.util.*;

/*
 * 0882-reachable-nodes-in-subdivided-graph.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/12
 */
public class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
        }

        return getReachableNodes(graph, 0, maxMoves);
    }

    public int getReachableNodes(Map<Integer, Map<Integer, Integer>> graph, Integer fromNode, int maxMoves) {
        if (!graph.containsKey(fromNode)) {
            return 0;
        }
        if (maxMoves <= 0) {
            return 0;
        }
        int total = 1;
        Map<Integer, Integer> points = graph.get(fromNode);
        while (!points.isEmpty()) {
            Iterator<Map.Entry<Integer, Integer>> it = points.entrySet().iterator();
            Map.Entry<Integer, Integer> entry = it.next();
            it.remove();
            if (entry.getValue() <= maxMoves - 1) {
                total += getReachableNodes(graph, entry.getValue(), maxMoves - 1 - entry.getValue());
            } else {
                total += maxMoves;
                graph.computeIfAbsent(entry.getKey(), k -> new HashMap<>()).put(fromNode, maxMoves - entry.getValue());
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.reachableNodes(
            new int[][]{{0,1,10}, {0,2,1}, {1,2,2}}, 6, 3));
        // 23
        System.out.println(s.reachableNodes(
            new int[][]{{0,1,4}, {1,2,6}, {0,2,8}, {1,3,1}}, 10, 4));
    }
}