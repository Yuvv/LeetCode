import java.util.*;

/**
 * 2285-maximum-total-importance-of-roads.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/28
 */
public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[][] vals = new int[n][2];
        for (int i = 0; i < n; i++) {
            vals[i][0] = i;
        }
        for (int[] road : roads) {
            vals[road[0]][1]++;
            vals[road[1]][1]++;
        }
        Arrays.sort(vals, (a, b) -> a[1] - b[1]);
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            int[] e = vals[i];
            weights[e[0]] = i+1;
        }
        long res = 0L;
        for (int[] road : roads) {
            res += weights[road[0]];
            res += weights[road[1]];
        }
        return res;
    }

    public long maximumImportance_pq(int n, int[][] roads) {
        int[] vals = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] road : roads) {
            map.put(road[0], map.getOrDefault(road[0], 0) + 1);
            map.put(road[1], map.getOrDefault(road[1], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        while (!pq.isEmpty()) {
            int[] can = pq.poll();
            vals[can[0]] = n;
            n--;
        }
        long res = 0L;
        for (int[] road : roads) {
            res += vals[road[0]];
            res += vals[road[1]];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 43
        System.out.println(s.maximumImportance(5, new int[][]{
            {0,1},{1,2},{2,3},{0,2},{1,3},{2,4}
        }));
        // 20
        System.out.println(s.maximumImportance(5, new int[][]{
            {0,3},{2,4},{1,3}
        }));
    }
}