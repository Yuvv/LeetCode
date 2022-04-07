import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * 0313-super-ugly-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/07
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int num : primes) {
            heap.add(new int[] {num, 0, num});
        }
        int i = 0;
        while (i < n - 1) {
            int[] candidate = heap.poll();
            if (candidate[2] > res[i]) {
                // 防止重复
                i++;
                res[i] = candidate[2];
            }
            candidate[1]++;
            candidate[2] = candidate[0] * res[candidate[1]];
            heap.add(candidate);
        }

        return res[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 32
        System.out.println(s.nthSuperUglyNumber(12, new int[] {2,7,13,19}));
        // 1
        System.out.println(s.nthSuperUglyNumber(1, new int[] {2,3,5}));
    }
}