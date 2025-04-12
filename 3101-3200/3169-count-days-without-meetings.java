import java.util.*;
/**
 * 3169-count-days-without-meetings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/12
 */
public class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int cnt = 0;
        if (meetings[0][0] > 1) {
            cnt += meetings[0][0] - 1;
        }
        int[] last = meetings[0];
        for (int i = 1; i < meetings.length; i++) {
            int[] cur = meetings[i];
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                cnt += cur[0] - last[1] - 1;
                last = cur;
            }
        }
        if (last[1] < days) {
            cnt += days - last[1];
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countDays(10, new int[][]{{5, 7}, {1, 3}, {9,10}}));
        // 1
        System.out.println(s.countDays(5, new int[][]{{2,4}, {1,3}}));
        // 0
        System.out.println(s.countDays(6, new int[][]{{1,6}}));
    }
}
