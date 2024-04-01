import java.util.*;

/**
 * 1630-arithmetic-subarrays.java
 *
 * @date 2024/4/1
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> resList = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            int bj = l[i];
            int ej = r[i];
            // check bj-ej
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int k = bj; k <= ej; k++) {
                pq.add(nums[k]);
            }
            boolean ok = true;
            Integer first = pq.poll();
            Integer next = pq.poll();
            int diff = next - first;
            while (!pq.isEmpty()) {
                if (diff != pq.peek() - next) {
                    ok = false;
                    break;
                }
                next = pq.poll();
            }
            resList.add(ok);
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [true, false, true]
        System.out.println(s.checkArithmeticSubarrays(
                new int[] { 4, 6, 5, 9, 3, 7 },
                new int[] { 0, 0, 2 },
                new int[] { 2, 3, 5 }));
        // [false,true,false,false,true,true]
        System.out.println(s.checkArithmeticSubarrays(
                new int[] { -12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10 },
                new int[] { 0, 1, 6, 4, 8, 7 },
                new int[] { 4, 4, 9, 7, 9, 10 }));
    }
}
