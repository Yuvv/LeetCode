import java.util.Arrays;
import java.util.Comparator;

/*
 * 1665-minimum-initial-energy-to-finish-tasks.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/28
 */
public class Solution {
    public int minimumEffort(int[][] tasks) {
        // reverse sort by diff
        Arrays.sort(tasks, Comparator.comparingInt(x -> x[0] - x[1]));

        int total = 0;
        int remain = 0;
        for (int[] task : tasks) {
            if (remain < task[1]) {
                int diff = task[1] - remain;
                total += diff;
                remain += diff;
            }
            remain -= task[0];
        }
        return total;
    }

     public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.minimumEffort(new int[][] {{1,2},{2,4},{4,8}}));
        // 32
        System.out.println(s.minimumEffort(new int[][] {{1,3},{2,4},{10,11},{10,12},{8,9}}));
        // 27
        System.out.println(s.minimumEffort(new int[][] {{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}}));

    }
}