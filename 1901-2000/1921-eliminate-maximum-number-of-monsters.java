import java.util.*;

/**
 * 1921-eliminate-maximum-number-of-monsters
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/19
 */
public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Float> pq = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            pq.add(((float) dist[i]) / speed[i]);
        }
        float elapsed = 0f;
        while (!pq.isEmpty()) {
            Float sec = pq.poll();
            if (sec - elapsed <= 0) {
                break;
            }
            elapsed += 1;
        }
        return (int) (elapsed);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.eliminateMaximum(new int[] { 1, 3, 4 }, new int[] { 1, 1, 1 }));
        // 1
        System.out.println(s.eliminateMaximum(new int[] { 1, 1, 2, 3 }, new int[] { 1, 1, 1, 1 }));
        // 1
        System.out.println(s.eliminateMaximum(new int[] { 3, 2, 4 }, new int[] { 5, 3, 2 }));
    }
}
