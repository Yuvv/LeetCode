import java.util.*;

/**
 * 1334-find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/26
 */
public class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
                Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] each : edges) {
            map.get(each[0]).put(each[1], each[2]);
            map.get(each[1]).put(each[0], each[2]);
        }
        int curnode = -1;
        int curmax = Integer.MAX_VALUE;
        Map<Integer, Integer> curset = new HashMap<>();
        for (Integer k : map.keySet()) {
            // bfs
            curset.clear();
            curset.put(k, distanceThreshold);
            LinkedList<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[]{distanceThreshold, k});
            while (!queue.isEmpty()) {
                Integer[] next = queue.poll();
                Integer thr = next[0];
                Integer key = next[1];
                for (Map.Entry<Integer, Integer> e : map.get(key).entrySet()) {
                    Integer nextThr = thr - e.getValue();
                    Integer ev = curset.get(e.getKey());
                    if (ev != null && ev >= nextThr) {
                        continue;
                    }
                    if (curset.size() > curmax) {
                        break;
                    }
                    if (nextThr >= 0) {
                        curset.put(e.getKey(), nextThr);
                        queue.push(new Integer[]{nextThr, e.getKey()});
                    }
                }
                if (curset.size() > curmax) {
                    break;
                }
            }
            if (curset.size() <= curmax) {
                curmax = curset.size();
                curnode = Math.max(curnode, k);
            }
        }
        return curnode;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.findTheCity(
            4, new int[][] {{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4
        ));
        // 0
        System.out.println(s.findTheCity(
            5, new int[][] {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2
        ));
    }
}
