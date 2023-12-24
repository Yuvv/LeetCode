import java.util.PriorityQueue;

/**
 * 1792-maximum-average-pass-ratio
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/24
 */
public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        if (classes.length == 1) {
            return (double) (classes[0][0] + extraStudents) / (classes[0][1] + extraStudents);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double diffRa = (double) (a[0] + 1) / (a[1] + 1) - (double) a[0] / a[1];
            double diffRb = (double) (b[0] + 1) / (b[1] + 1) - (double) b[0] / b[1];
            if (diffRa > diffRb) {
                return -1;
            } else if (diffRa < diffRb) {
                return 1;
            }
            return 0;
        });
        for (int[] cls : classes) {
            pq.add(cls);
        }
        while (extraStudents > 0) {
            int[] a = pq.poll();
            a[0]++;
            a[1]++;
            pq.add(a);
            extraStudents--;
        }
        double totalRatio = 0D;
        while (!pq.isEmpty()) {
            int[] cls = pq.poll();
            totalRatio += (double) cls[0] / cls[1];
        }
        return totalRatio / classes.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0.78333
        System.out.println(s.maxAverageRatio(
                new int[][] { { 1, 2 }, { 3, 5 }, { 2, 2 } }, 2));
        // 0.53485
        System.out.println(s.maxAverageRatio(
                new int[][] { { 2, 4 }, { 3, 9 }, { 4, 5 }, { 2, 10 } }, 4));
    }
}
