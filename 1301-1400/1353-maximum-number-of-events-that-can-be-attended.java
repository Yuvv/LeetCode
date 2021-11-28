import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 1353-maximum-number-of-events-that-can-be-attended.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/28
 */
public class Solution {
    public int maxEvents_tle(int[][] events) {
        // sort by startDay & endDay
        Arrays.sort(events, (a, b) -> {
            int res = a[0] - b[0];
            if (res == 0) {
                res = a[1] - b[1];
            }
            return res;
        });

        Set<Integer> attendedDaySet = new HashSet<>();
        for (int i = events.length - 1; i >= 0; i--) {
            int[] event = events[i];
            for (int j = event[1]; j >= event[0]; j--) {
                if (!attendedDaySet.contains(j)) {
                    attendedDaySet.add(j);
                    break;
                }
            }
        }
        return attendedDaySet.size();
    }

     public int maxEvents(int[][] events) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int maxEvents = 0;
        int day = 1;//start from 1st day.
        int n = events.length;
        int i = 0;
        while(!minHeap.isEmpty() || i < n) {
            //4. Before moving to next, remove the ones that ends before the current day.
            while (!minHeap.isEmpty() && minHeap.peek()[1] < day) {
                minHeap.poll();
            }
            // 1. Consider the ones startes today(day or before)
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i]);
                i++;
            }
            // 2. attend the one which ends first on that day
            if (!minHeap.isEmpty()) {
                maxEvents++;
                minHeap.poll();
            }
            // 3. move to next day
            day++;
        }
        return maxEvents;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxEvents(new int[][] {{1,2},{2,3},{3,4}}));
        // 4
        System.out.println(s.maxEvents(new int[][] {{1,4},{4,4},{2,2},{3,4},{1,1}}));
        // 4
        System.out.println(s.maxEvents(new int[][] {{1,2},{2,3},{3,4},{1,2}}));
        // 1
        System.out.println(s.maxEvents(new int[][] {{1,1002}}));
        // 7
        System.out.println(s.maxEvents(new int[][] {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}}));
    }
}