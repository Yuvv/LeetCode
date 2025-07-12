/**
 * 3440-reschedule-meetings-for-maximum-free-time-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/12
 */
public class Solution {
    private int replaceGap(int[] top3gaps, int a, int b, int gap) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int i = 0;
        if (top3gaps[i] == a) {
            i++;
        }
        if (top3gaps[i] == b) {
            i++;
        }
        if (gap <= top3gaps[i]) {
            return gap;
        }
        return 0;
    }
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] top3gaps = new int[]{startTime[0], 0, 0};
        for (int i = 1; i <= startTime.length; i++) {
            int gap;
            if (i == startTime.length) {
                gap = eventTime - endTime[i - 1];
            } else {
                gap = startTime[i] - endTime[i - 1];
            }
            if (gap > top3gaps[0]) {
                top3gaps[2] = top3gaps[1];
                top3gaps[1] = top3gaps[0];
                top3gaps[0] = gap;
            } else if (gap > top3gaps[1]) {
                top3gaps[2] = top3gaps[1];
                top3gaps[1] = gap;
            } else if (gap > top3gaps[2]) {
                top3gaps[2] = gap;
            }
        }
        int max = startTime[0];
        int free = startTime[0];
        int last = startTime[0];
        for (int i = 1; i < startTime.length; i++) {
            free += startTime[i] - endTime[i - 1];
            max = Math.max(max, free + replaceGap(top3gaps, last, startTime[i]-endTime[i-1], endTime[i-1] - startTime[i-1]));
            free -= last;
            last = startTime[i] - endTime[i - 1];
        }
        free += eventTime - endTime[startTime.length - 1];
        max = Math.max(max, free + replaceGap(top3gaps, eventTime-endTime[startTime.length-1], last, endTime[startTime.length - 1] - startTime[startTime.length - 1]));
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxFreeTime(
            5, new int[]{1,3}, new int[]{2,5}
        ));
        // 7
        System.out.println(s.maxFreeTime(
            10, new int[]{0,7,9}, new int[]{1,8,10}
        ));
        // 6
        System.out.println(s.maxFreeTime(
            10, new int[]{0,3,7,9}, new int[]{1,4,8,10}
        ));
        // 0
        System.out.println(s.maxFreeTime(
            5, new int[]{0,1,2,3,4}, new int[]{1,2,3,4,5}
        ));
    }
}