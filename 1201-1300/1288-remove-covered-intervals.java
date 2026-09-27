import java.util.*;
/**
 * 1288-remove-covered-intervals.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/09/27
 */
public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0;
        int i = 0;
        while (i < intervals.length) {
            int j = i + 1;
            while (j < intervals.length && intervals[j][1] <= intervals[i][1]) {
                j++;
            }
            i = j;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        int result = s.removeCoveredIntervals(intervals);
        System.out.println(result); // Output: 2
        // 1
        System.out.println(s.removeCoveredIntervals(new int[][]{{1, 4}, {2, 3}})); // Output: 1
    }
}