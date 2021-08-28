import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/*
 * 1235-maximum-profit-in-job-scheduling.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/28
 */
public class Solution {
    private Map<Integer, Integer> cacheMap;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        cacheMap = new HashMap<>(startTime.length);

        int[][] timeRangeProfit = new int[startTime.length][];
        for (int i = 0; i < startTime.length; i++) {
            timeRangeProfit[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(timeRangeProfit, (o1, o2) -> {
            int r = Integer.compare(o1[0], o2[0]);
            if (r == 0) {
                r = Integer.compare(o1[1], o2[1]);
                if (r == 0) {
                    r = Integer.compare(o1[2], o2[2]);
                }
            }
            return r;
        });
        return jobScheduling(timeRangeProfit, 0);
    }

    public int jobScheduling(int[][] timeRangeProfit, int fromIdx) {
        if (cacheMap.containsKey(fromIdx)) {
            return cacheMap.get(fromIdx);
        }
        if (fromIdx >= timeRangeProfit.length) {
            return 0;
        }
        int maxPft = 0;
        for (int i = fromIdx; i < timeRangeProfit.length && timeRangeProfit[i][0] < timeRangeProfit[fromIdx][1]; i++) {
            // find next idx
            int nextIdx = i + 1;
            while (nextIdx < timeRangeProfit.length && timeRangeProfit[nextIdx][0] < timeRangeProfit[i][1]) {
                nextIdx++;
            }
            maxPft = Math.max(maxPft, timeRangeProfit[i][2] + jobScheduling(timeRangeProfit, nextIdx));
        }
        cacheMap.put(fromIdx, maxPft);
        return maxPft;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 150
        System.out.println(s.jobScheduling(new int[] {1, 2, 3, 6, 4}, new int[]{3, 5, 10, 9, 6}, new int[]{20, 20, 100, 70, 60}));
        // 150
        System.out.println(s.jobScheduling(new int[] {1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
        // 120
        System.out.println(s.jobScheduling(new int[] {1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
        // 6
        System.out.println(s.jobScheduling(new int[] {1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
    }
}