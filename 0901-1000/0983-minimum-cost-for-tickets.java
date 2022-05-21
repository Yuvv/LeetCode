/*
 * 0983-minimum-cost-for-tickets.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/21
 */
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // dp[i][j] means the minium cost if travl `j` day in i-th day
        int[][] dp = new int[days[days.length - 1] + 1][3];
        for (int[] each : dp) {
            java.util.Arrays.fill(each, Integer.MAX_VALUE);
        }
        return findMin(days, 0, costs, dp);
    }

    public int findMin(int[] days, int di, int[] costs, int[][] dp) {
        if (di >= days.length) {
            return 0;
        }
        int dpi = days[di];
        int nextDpi;
        int min = Integer.MAX_VALUE;
        // try travl 1/7/30 day to find minium cost
        if (dp[dpi][0] == Integer.MAX_VALUE) {
            nextDpi = findNextIdx(days, di, days[di]);
            dp[dpi][0] = costs[0] + findMin(days, nextDpi, costs, dp);
        }
        min = Math.min(min, dp[dpi][0]);

        if (dp[dpi][1] == Integer.MAX_VALUE) {
            nextDpi = findNextIdx(days, di, days[di] + 6);
            dp[dpi][1] = costs[1] + findMin(days, nextDpi, costs, dp);
        }
        min = Math.min(min, dp[dpi][1]);

        if (dp[dpi][2] == Integer.MAX_VALUE) {
            nextDpi = findNextIdx(days, di, days[di] + 29);
            dp[dpi][2] = costs[2] + findMin(days, nextDpi, costs, dp);
        }
        min = Math.min(min, dp[dpi][2]);

        return min;
    }

    public int findNextIdx(int[] days, int di, int val) {
        int i = di;
        while (i < days.length) {
            if (days[i] > val) {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 11
        System.out.println(s.mincostTickets(
            new int[] {1,4,6,7,8,20},
            new int[] {2,7,15}
        ));
        // 17
        System.out.println(s.mincostTickets(
            new int[] {1,2,3,4,5,6,7,8,9,10,30,31},
            new int[] {2,7,15}
        ));
    }
}