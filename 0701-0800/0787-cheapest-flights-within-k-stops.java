import java.util.*;

/**
 * 0787-cheapest-flights-within-k-stops.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/16
 */
public class Solution {
    // dfs_dp ACCEPT
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][][] dp = new int[n][n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    Arrays.fill(dp[i][j], 0);
                } else {
                    Arrays.fill(dp[i][j], -2);
                }
            }
        }
        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        for (int[] fl : flights) {
            dp[fl[0]][fl[1]][0] = fl[2];
            nextMap.computeIfAbsent(fl[0], x -> new ArrayList<>()).add(fl[1]);
        }
        for (int i = 0; i < n; i++) {
            if (!nextMap.containsKey(i)) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        Arrays.fill(dp[i][j], -1);
                    }
                }
            }
        }
        int v = dfs(dp, nextMap, src, dst, k);
        if (v >= 0) {
            return v;
        }
        return -1;
    }

    private int dfs(int[][][] dp, Map<Integer, List<Integer>> nextMap, int src, int dst, int k) {
        if (k < 0) {
            return -1;
        }
        if (dp[src][dst][k] > -2) {
            return dp[src][dst][k];
        }

        int v = Integer.MAX_VALUE;
        for (int next : nextMap.get(src)) {
            int nv = dfs(dp, nextMap, next, dst, k-1);
            if (nv >= 0) {
                v = Math.min(v, nv + dp[src][next][0]);
            }
        }
        if (v == Integer.MAX_VALUE) {
            v = -1;
        }
        dp[src][dst][k] = v;
        return v;
    }

    public int findCheapestPrice_tle(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] e : flights) {
            map.computeIfAbsent(e[0], x -> new ArrayList<>()).add(new int[]{e[1], e[2]});
        }
        Set<Integer> router = new HashSet<>();

        int v = dfs(map, src, dst, k+1, router);
        if (v == Integer.MAX_VALUE || v < 0) {
            return -1;
        }
        return v;
    }

    private int dfs(Map<Integer, List<int[]>> map, int src, int dst, int MAXK, Set<Integer> router) {
        if (router.size() > MAXK) {
            return -1;
        }
        if (src == dst) {
            return 0;
        }
        if (!map.containsKey(src) ) {
            return -1;
        }
        router.add(src);
        int curPrice = Integer.MAX_VALUE;
        for (int[] next : map.get(src)) {
            if (router.contains(next[0])) {
                continue;
            }
            int price = dfs(map, next[0], dst, MAXK, router);
            if (price >= 0) {
                curPrice = Math.min(curPrice, price + next[1]);
            }
        }
        router.remove(src);
        return curPrice == Integer.MAX_VALUE ? -1 : curPrice;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 700
        System.out.println(s.findCheapestPrice(
            4,
            new int[][] {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}},
            0, 3, 1
        ));
        // 200
        System.out.println(s.findCheapestPrice(
            3,
            new int[][] {{0,1,100}, {1,2,100}, {0,2,500}},
            0, 2, 1
        ));
        // 500
        System.out.println(s.findCheapestPrice(
            3,
            new int[][] {{0,1,100}, {1,2,100}, {0,2,500}},
            0, 2, 0
        ));
    }
}
