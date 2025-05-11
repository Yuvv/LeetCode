import java.util.PriorityQueue;
/**
 * 2593-find-score-of-an-array-after-marking-all-elements.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/11
 */
public class Solution {
    // 1 <= nums[i] <= 10^5
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int d = a[0] - b[0];
            if (d == 0) {
                return a[1] - b[1];
            }
            return d;
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        long score = 0L;
        while (!pq.isEmpty()) {
            int[] it = pq.poll();
            if (nums[it[1]] == -1) {
                continue;
            }
            score += it[0];
            nums[it[1]] = -1;
            if (it[1] > 0 && nums[it[1]-1] != -1) {
                nums[it[1]-1] = -1;
            }
            if (it[1] < nums.length - 1 && nums[it[1]+1] != -1) {
                nums[it[1]+1] = -1;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.findScore(new int[]{2,1,3,4,5,2}));
        // 5
        System.out.println(s.findScore(new int[]{2,3,5,1,3,2}));
    }
}