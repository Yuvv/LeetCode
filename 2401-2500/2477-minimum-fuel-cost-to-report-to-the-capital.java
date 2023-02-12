import java.util.*;

/*
 * 2477-minimum-fuel-cost-to-report-to-the-capital.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/02/12
 */
public class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> roadMap = new HashMap<>();
        for (int[] road : roads) {
            roadMap.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
            roadMap.computeIfAbsent(road[1], k -> new ArrayList<>()).add(road[0]);
        }
        boolean[] traveled = new boolean[roads.length + 1];
        long[] res = dfs(roadMap, 0, traveled, seats);
        return res[1];
    }

    public long[] dfs(Map<Integer, List<Integer>> roadMap, int node, boolean[] traveled, int seats) {
        long[] res = new long[] {0, 0};  // 0-nodeCount, 1-roadLen
        if (traveled[node]) {
            return res;
        }
        traveled[node] = true;
        List<Integer> nextList = roadMap.get(node);
        if (nextList != null) {
            for (Integer next : nextList) {
                if (traveled[next]) {
                    continue;
                }
                long[] sub = dfs(roadMap, next, traveled, seats);
                res[0] += sub[0];
                res[1] += sub[1] + (sub[0] + seats - 1) / seats;
            }
        }

        res[0]++; // add current node
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minimumFuelCost(
            new int[][] {{0,1},{0,2}, {0,3}}, 5
        ));
        // 7
        System.out.println(s.minimumFuelCost(
            new int[][] {{3,1}, {3,2}, {1,0}, {0,4}, {0,5}, {4,6}}, 2
        ));
        // 10
        System.out.println(s.minimumFuelCost(
                new int[][] {{0,1}, {0,6},{4,0}, {1,9}, {8,9}, {3,6}, {6,2}, {3,7}, {4,5}}, 3
        ));
    }
}