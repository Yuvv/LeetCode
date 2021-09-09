import java.util.*;

/*
 * 0764-largest-plus-sign.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/09
 */
public class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        Map<Integer, Set<Integer>> set = new HashMap<>();
        for (int[] am : mines) {
            set.computeIfAbsent(am[0], k -> new HashSet<>(n)).add(am[1]);
        }
        int count;
        // build left & right
        for (int i = 0; i < n; i++) {
            // left
            count = 0;
            for (int j = 0; j < n; j++) {
                if (set.containsKey(i) && set.get(i).contains(j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = count;
            }
            // right
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] == 0) {
                    count = 0;
                    continue;
                }
                count++;
                dp[i][j] = Math.min(count, dp[i][j]);
            }
        }

        // build up & down
        for (int j = 0; j < n; j++) {
            // up
            count = 0;
            for (int i = 0; i < n; i++) {
                if (dp[i][j] == 0) {
                    count = 0;
                    continue;
                }
                count++;
                dp[i][j] = Math.min(count, dp[i][j]);
            }
            // down
            count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (dp[i][j] == 0) {
                    count = 0;
                    continue;
                }
                count++;
                dp[i][j] = Math.min(count, dp[i][j]);
            }
        }

        // find result
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
        // 0
        System.out.println(s.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
    }
}