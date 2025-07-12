/**
 * 3439-reschedule-meetings-for-maximum-free-time-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/12
 */
public class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int freeCnt = startTime[0];
        int j = 1;
        while (j <= k && j <= startTime.length) {
            if (j == startTime.length) {
                freeCnt += eventTime - endTime[j-1];
            } else {
                freeCnt += startTime[j] - endTime[j-1];
            }
            j++;
        }
        int max = freeCnt;
        int i = 0;
        while (j <= startTime.length) {
            if (i == 0) {
                freeCnt -= startTime[i];
            } else {
                freeCnt -= startTime[i] - endTime[i-1];
            }
            if (j == startTime.length) {
                freeCnt += eventTime - endTime[j-1];
            } else if (j < startTime.length) {
                freeCnt += startTime[j] - endTime[j-1];
            }
            max = Math.max(max, freeCnt);
            i++;
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxFreeTime(
            5, 1, new int[]{1,3}, new int[]{2,5}
        ));
        // 6
        System.out.println(s.maxFreeTime(
            10, 1, new int[]{0,2,9}, new int[]{1,4,10}
        ));
        // 0
        System.out.println(s.maxFreeTime(
            5, 2, new int[]{0,1,2,3,4}, new int[]{1,2,3,4,5}
        ));
    }
}