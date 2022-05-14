import java.util.*;

/*
 * 0743-network-delay-time.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/14
 */
public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] kToArray = new int[n + 1];
        Arrays.fill(kToArray, -1);
        kToArray[0] = 0;
        kToArray[k] = 0;

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] row : times) {
            graph.computeIfAbsent(row[0], key -> new HashMap<>()).put(row[1], row[2]);
        }

        // depth-first-search
        // dfs(graph, 0, k, kToArray);

        // dijkstra's algorithm
        dijkstra(graph, k, kToArray);

        int max = 0;
        for (int time : kToArray) {
            if (time < 0) {
                return -1;
            }
            max = Math.max(max, time);
        }

        return max;
    }

    public void dfs(Map<Integer, Map<Integer, Integer>> graph, int currentTime, int k, int[] kToArray) {
        if (!graph.containsKey(k)) {
            return;
        }
        Map<Integer, Integer> map = graph.get(k);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int time = currentTime + entry.getValue();
            if (kToArray[entry.getKey()] < 0 || kToArray[entry.getKey()] > time) {
                kToArray[entry.getKey()] = time;
                dfs(graph, time, entry.getKey(), kToArray);
            }
        }
    }

    public void dijkstra(Map<Integer, Map<Integer, Integer>> graph, int k, int[] kToArray) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
        pq.add(new int[] {0, k});

        while (!pq.isEmpty()) {
            int[] ele = pq.poll();
            int currentTime = ele[0];

            if (kToArray[ele[1]] >= 0 && kToArray[ele[1]] < currentTime) {
                continue;
            }
            if (!graph.containsKey(ele[1])) {
                continue;
            }

            for (Map.Entry<Integer, Integer> entry : graph.get(ele[1]).entrySet()) {
                int target = entry.getKey();
                int time = entry.getValue() + currentTime;
                if (kToArray[target] < 0 || kToArray[target] > time) {
                    kToArray[target] = time;
                    pq.add(new int[] {time, target});
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.networkDelayTime(
            new int[][] {{2,1,1}, {2,3,1}, {3,4,1}},
            4, 2
        ));
        // 1
        System.out.println(s.networkDelayTime(
            new int[][] {{1,2,1}},
            2, 1
        ));
        // -1
        System.out.println(s.networkDelayTime(
            new int[][] {{1,2,1}},
            2, 2
        ));
    }
}