import java.util.*;

/*
 * 0539-minimum-time-difference.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/15
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] timeArray = new int[60*24];
        Arrays.fill(timeArray, -1);
        for (String ts : timePoints) {
            int h = Integer.parseInt(ts.substring(0, 2));
            int m = Integer.parseInt(ts.substring(3, 5));
            int mm = h*60+m;
            if (timeArray[mm] >= 0) {
                return 0;
            }
            timeArray[mm] = mm;
        }
        int min = 60*24;
        int last = -1;
        for (int time : timeArray) {
            if (time >= 0) {
                if (last >= 0) {
                    min = Math.min(min, time - last);
                }
                last = time;
            }
        }
        for (int time : timeArray) {
            if (time >= 0) {
                min = Math.min(min, time + 1440 - last);
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.findMinDifference(Arrays.asList("23:59", "00:00")));
        // 0
        System.out.println(s.findMinDifference(Arrays.asList("00:00", "23:59", "00:00")));
    }
}