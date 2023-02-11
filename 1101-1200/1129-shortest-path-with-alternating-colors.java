import java.util.*;

/*
 * 1129-shortest-path-with-alternating-colors.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/02/11
 */
public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, Map<Integer, List<Integer>>> nextMap = new HashMap<>(n);
        for (int[] edge : redEdges) {
            nextMap.computeIfAbsent(edge[0], k -> new HashMap<>(2))
                    .computeIfAbsent(0, k -> new ArrayList<>())
                    .add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            nextMap.computeIfAbsent(edge[0], k -> new HashMap<>(2))
                    .computeIfAbsent(1, k -> new ArrayList<>())
                    .add(edge[1]);
        }

        int[] already = new int[n];
        int[] res = new int[n];
        Arrays.fill(res, -1);
        LinkedList<int[]> candidate = new LinkedList<>();
        candidate.push(new int[]{0, 0}); // 0-red
        candidate.push(new int[]{1, 0}); // 1-blue
        already[0] = 3;
        res[0] = 0;
        int dis = 0;
        while (!candidate.isEmpty()) {
            int size = candidate.size();
            dis++;
            while (size > 0) {
                int[] arrow = candidate.poll();
                if (nextMap.containsKey(arrow[1])) {
                    List<Integer> next = nextMap.get(arrow[1]).get(1 - arrow[0]);
                    if (next != null) {
                        for (Integer e : next) {
                            if (res[e] < 0) {
                                res[e] = dis;
                            } else {
                                res[e] = Math.min(dis, res[e]);
                            }
                            if ((already[e] & (arrow[0]+1)) > 0) {
                                continue;
                            }
                            candidate.addLast(new int[]{1 - arrow[0], e.intValue()});
                            already[e] |= arrow[0] + 1;
                        }
                    }
                }
                size--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1,-1]
        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
            3, new int[][] {{0,1}, {1,2}}, new int[][]{}
        )));
        // [0,1,-1]
        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
            3, new int[][] {{0,1}}, new int[][]{{2,1}}
        )));
        // [0,1,2,1,-1,2,2,3,-1,4]
        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
            10,
            new int[][] {{0,1},{0,3},{4,5},{7,8},{5,7},{1,7}},
            new int[][]{{2,1},{1,2},{3,5},{3,6},{7,9}}
        )));
    }
}