import java.util.*;

/**
 * 1514-path-with-maximum-probability.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/31
 */
public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<int[]>> edgeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            edgeMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], i});
            edgeMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], i});
        }
        LinkedList<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{start_node, 1.0D});
        double[] probs = new double[n];
        while (!queue.isEmpty()) {
            Object[] entry = queue.poll();
            Integer node = (Integer) entry[0];
            Double curProb = (Double) entry[1];
            if (curProb <= probs[node]) {
                continue;
            }
            probs[node] = curProb;
            List<int[]> nextSet = edgeMap.get(node);
            if (nextSet == null) {
                continue;
            }
            for (int[] nodeIdx : nextSet) {
                double prob = succProb[nodeIdx[1]];
                queue.add(new Object[]{nodeIdx[0], curProb * prob});
            }
        }

        return probs[end_node];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0.25
        System.out.println(s.maxProbability(
            3, new int[][] {{0,1},{1,2},{0,2}}, new double[]{0.5, 0.5, 0.2}, 0, 2
        ));
        // 0.3
        System.out.println(s.maxProbability(
            3, new int[][] {{0,1},{1,2},{0,2}}, new double[]{0.5, 0.5, 0.3}, 0, 2
        ));
        // 0.25
        System.out.println(s.maxProbability(
            3, new int[][] {{0,1}}, new double[]{0.5}, 0, 2
        ));
    }
}
