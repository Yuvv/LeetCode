import java.util.HashMap;
import java.util.Map;

/**
 * 2365-task-scheduler-ii.java
 *
 * @author Yuvv<yuvv_th@outlook.com>
 * @date 2024/3/19
 */
public class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long time = 0L;
        for (int t : tasks) {
            Long lastTime = map.get(t);
            time++;
            if (lastTime == null) {
                map.put(t, time);
            } else {
                time = Math.max(lastTime + space + 1, time);
                map.put(t, time);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.taskSchedulerII(new int[]{1,2,1,2,3,1}, 3));
        // 6
        System.out.println(s.taskSchedulerII(new int[]{5,8,8,5}, 2));
    }
}
