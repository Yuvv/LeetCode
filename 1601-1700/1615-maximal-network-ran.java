import java.util.*;

/*
 * 1615-maximal-network-ran.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/10
 */
public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            map.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            pq.add(new int[] {entry.getKey(), entry.getValue().size()});
        }

        if (!pq.isEmpty()) {
            int[] candidate1 = pq.poll();
            List<Integer> vertexList1 = new ArrayList<>();
            vertexList1.add(candidate1[0]);
            while (!pq.isEmpty() && pq.peek()[1] == candidate1[1]) {
                int[] c = pq.poll();
                vertexList1.add(c[0]);
            }
            if (vertexList1.size() > 1) {
                for (int i = 0; i < vertexList1.size(); i++) {
                    Integer a = vertexList1.get(i);
                    for (int j = i + 1; j < vertexList1.size(); j++) {
                        Integer b = vertexList1.get(j);
                        if (!map.get(a).contains(b)) {
                            return candidate1[1] * 2;
                        }
                    }
                }
                return candidate1[1] * 2 - 1;
            } else {
                int[] candidate2 = pq.poll();
                List<Integer> vertexList2 = new ArrayList<>();
                vertexList2.add(candidate2[0]);
                while (!pq.isEmpty() && pq.peek()[1] == candidate2[1]) {
                    int[] c = pq.poll();
                    vertexList2.add(c[0]);
                }

                Integer a = candidate1[0];
                for (int i = 0; i < vertexList2.size(); i++) {
                    Integer b = vertexList2.get(i);
                    if (!map.get(a).contains(b)) {
                        return candidate1[1] + candidate2[1];
                    }
                }
                return candidate1[1] + candidate2[1] - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maximalNetworkRank(
            4,
            new int[][] {{9,1}, {0,3}, {1,2}, {1,3}}
        ));
        // 5
        System.out.println(s.maximalNetworkRank(
            5,
            new int[][] {{0,1}, {0,3}, {1,2}, {1,3}, {2,3}, {2,4}}
        ));
    }
}