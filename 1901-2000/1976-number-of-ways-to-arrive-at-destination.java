import java.util.*;
/**
 * 1976-number-of-ways-to-arrive-at-destination.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/03/23
 */
public class Solution {
    // TLE
    public int countPaths_tle(int n, int[][] roads) {
        long cnt = 0L;
        LinkedList<long[]> queue = new LinkedList<>();
        queue.add(new long[]{0, 0});  // first is node, second is weight

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new HashMap<>()).put(road[1], road[2]);
            graph.computeIfAbsent(road[1], k -> new HashMap<>()).put(road[0], road[2]);
        }

        long[] minPath = buildMinPath(n, graph);
        System.out.println(Arrays.toString(minPath));

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                long[] node = queue.poll();
                size--;
                Map<Integer, Integer> nextMap = graph.get((int) (node[0]));
                if (nextMap == null) {
                    continue;
                }
                for (Map.Entry<Integer, Integer> entry : nextMap.entrySet()) {
                    long nextWeight = node[1] + entry.getValue();
                    long curMinP = minPath[entry.getKey()];
                    if (nextWeight > curMinP) {
                        continue;
                    }
                    if (entry.getKey() == n - 1) {
                        if (nextWeight == curMinP) {
                            cnt++;
                            cnt %= 1000000007L;
                        } else {
                            cnt = 1;
                        }
                    }
                    minPath[entry.getKey()] = nextWeight;
                    queue.add(new long[]{entry.getKey(), nextWeight});
                }
            }
        }
        System.out.println("min=" + minPath[n - 1]);
        return (int) (cnt);
    }

    private long[] buildMinPath(int n, Map<Integer, Map<Integer, Integer>> graph) {
        long[] dist = new long[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            if (visited[(int) (node[0])]) {
                continue;
            }
            visited[(int) (node[0])] = true;
            Map<Integer, Integer> nextMap = graph.get((int) (node[0]));
            if (nextMap == null) {
                continue;
            }
            for (Map.Entry<Integer, Integer> entry : nextMap.entrySet()) {
                long w = dist[(int) (node[0])] + entry.getValue();
                if (dist[entry.getKey()] < 0 || dist[entry.getKey()] > w) {
                    dist[entry.getKey()] = w;
                    pq.add(new long[]{entry.getKey(), dist[entry.getKey()]});
                }
            }
        }

        return dist;
    }

    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int startNode = road[0], endNode = road[1], travelTime = road[2];
            graph.get(startNode).add(new int[] { endNode, travelTime });
            graph.get(endNode).add(new int[] { startNode, travelTime });
        }

        // Min-Heap (priority queue) for Dijkstra
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(
            Comparator.comparingLong(a -> a[0])
        );

        // Store shortest time to each node
        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        // Number of ways to reach each node in shortest time
        int[] pathCount = new int[n];

        shortestTime[0] = 0; // Distance to source is 0
        pathCount[0] = 1; // 1 way to reach node 0

        minHeap.offer(new long[] { 0, 0 }); // {time, node}

        while (!minHeap.isEmpty()) {
            long[] top = minHeap.poll();
            long currTime = top[0]; // Current shortest time
            int currNode = (int) top[1];

            // Skip outdated distances
            if (currTime > shortestTime[currNode]) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {
                int neighborNode = neighbor[0], roadTime = neighbor[1];

                // Found a new shortest path → Update shortest time and reset path count
                if (currTime + roadTime < shortestTime[neighborNode]) {
                    shortestTime[neighborNode] = currTime + roadTime;
                    pathCount[neighborNode] = pathCount[currNode];
                    minHeap.offer(
                        new long[] { shortestTime[neighborNode], neighborNode }
                    );
                }
                // Found another way with the same shortest time → Add to path count
                else if (currTime + roadTime == shortestTime[neighborNode]) {
                    pathCount[neighborNode] =
                        (pathCount[neighborNode] + pathCount[currNode]) % MOD;
                }
            }
        }

        return pathCount[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
        // Output: 4
        System.out.println(s.countPaths(
                7,
                new int[][]{
                        {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}
                }
        ));
    }
}