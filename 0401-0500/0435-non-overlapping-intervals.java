import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * 0435-non-overlapping-intervals
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/15
 */
public class Solution {

    // greedy - AC
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            return a[1]-b[1];
        });
        int i = 0;
        int count = 1;
        for (int j = 1; j < intervals.length; j++) {
            if (intervals[j][0]>=intervals[i][1]) {
                i = j;
                count++;
            }
        }

        return intervals.length - count;
    }

    // dp - TLE
    public int eraseOverlapIntervals_tle(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, -1);
        dp[dp.length - 1] = 0;

        dfs(dp, 0, intervals);
        // for (int i = dp.length-2; i>=0; i--) {
        // dfs(dp, i, intervals);
        // }
        return dp[0];
    }

    private int dfs(int[] dp, int i, int[][] intervals) {
        if (i >= dp.length) {
            return 0;
        }
        if (dp[i] >= 0) {
            return dp[i];
        }
        // remove this one
        int a = 1 + dfs(dp, i + 1, intervals);
        // retain this one
        int j = i + 1;
        while (j < dp.length && intervals[j][0] < intervals[i][1]) {
            j++;
        }
        int b = j - i - 1 + dfs(dp, j, intervals);
        dp[i] = Math.min(a, b);
        return dp[i];
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        // 1
        System.out.println(s.eraseOverlapIntervals(
                new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));
        // 2
        System.out.println(s.eraseOverlapIntervals(
                new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }));
        // 0
        System.out.println(s.eraseOverlapIntervals(
                new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }));

        if (args.length > 0) {
            long begin = System.currentTimeMillis();
            Scanner scanner = new java.util.Scanner(new FileInputStream(args[0]));
            String line = scanner.next();
            line = line.trim();
            line = line.substring(2, line.length() - 2);
            String[] itemList = line.split("\\],\\[");
            int[][] testcase = new int[itemList.length][2];
            for (int i = 0; i < itemList.length; i++) {
                String item = itemList[i];
                String[] each = item.split(",");
                testcase[i][0] = Integer.parseInt(each[0]);
                testcase[i][1] = Integer.parseInt(each[1]);
            }
            System.out.println(s.eraseOverlapIntervals(testcase));

            long end = System.currentTimeMillis();
            System.out.println("elapsed: " + (end - begin));
        }
    }
}
