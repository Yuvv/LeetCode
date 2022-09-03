import java.util.*;

/*
 * 2316-count-unreachable-pairs-of-nodes-in-an-undirected-graph.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/29
 */
public class Solution {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            map.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            map.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] dus = new int[n];
        Arrays.fill(dus, -1);
        for (int i = 0; i < n; i++) {
            if (dus[i] >= 0) {
                continue;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);
            Set<Integer> set = new HashSet<>();
            while (!queue.isEmpty()) {
                Integer val = queue.poll();
                if (!set.add(val)) {
                    continue;
                }
                if (dus[val] >= 0) {
                    continue;
                }
                queue.addAll(map.getOrDefault(val, Collections.emptySet()));
            }
            for (Integer val : set) {
                dus[val] = i;
            }
            countMap.put(i, set.size());
        }

        long total = 0L;
        for (Integer cnt : countMap.values()) {
            total += (long) cnt * (n - cnt);
        }

        return total / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.countPairs(
            3,
            new int[][] {{0,1}, {0,2}, {1,2}}
        ));
        // 14
        System.out.println(s.countPairs(
            7,
            new int[][] {{0,2}, {0,5}, {2,4}, {1,6}, {5,4}}
        ));
        // 16
        System.out.println(s.countPairs(
            10,
            new int[][] {{0,2}, {0,5}, {2,4}, {1,6}, {5,4}, {3,7}, {7,8}, {8,9}, {9,4}}
        ));
        // 100000
        System.out.println(s.countPairs(
            100000,
            new int[][] {}
        ));
    }
}