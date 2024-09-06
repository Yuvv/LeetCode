import java.util.*;
/**
 * 3264-final-array-state-after-k-multiplication-operations-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/06
 */
public class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] {nums[i], i});
        }
        while (k > 0) {
            int[] x = pq.poll();
            x[0] *= multiplier;
            pq.add(x);
            k--;
        }
        while (!pq.isEmpty()) {
            int[] x = pq.poll();
            nums[x[1]] = x[0];
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [8,4,6,5,6]
        System.out.println(Arrays.toString(s.getFinalState(
            new int[] {2,1,3,5,6}, 5, 2
        )));
    }
}
