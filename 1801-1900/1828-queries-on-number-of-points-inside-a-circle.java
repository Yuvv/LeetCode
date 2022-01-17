import java.util.*;

/*
 * 1828-queries-on-number-of-points-inside-a-circle.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/17
 */
public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int[] pt : points) {
            int a = pt[0] * pt[0] + pt[1] * pt[1];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(pt);
        }
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int rPow = query[2] * query[2];
            int a = query[0] * query[0] + query[1] * query[1];
            double sqrtax2 = 2 * Math.sqrt(a) * query[2];
            int minPow = a + rPow - (int) Math.ceil(sqrtax2);
            int maxPow = a + rPow + (int) Math.ceil(sqrtax2);
            if (a < rPow) {
                minPow = 0;
            }
            // range query
            long count = map.subMap(minPow, true, maxPow, true).values().stream()
                    .flatMap(List::stream)
                    .filter(pt -> {
                        int dx = pt[0] - query[0];
                        int dy = pt[1] - query[1];
                        return dx * dx + dy * dy <= rPow;
                    }).count();
            res[i++] = (int) count;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,3,2,4]
        System.out.println(Arrays.toString(s.countPoints(
            new int[][] {{1,1}, {2,2}, {3,3}, {4,4}, {5,5}},
            new int[][] {{1,2,2}, {2,2,2}, {4,3,2}, {4,3,3}}
        )));
        // [3,2,2]
        System.out.println(Arrays.toString(s.countPoints(
            new int[][] {{1,3}, {3,3}, {5,3},{2,2}},
            new int[][] {{2,3,1}, {4,3,1}, {1,1,2}}
        )));
    }
}