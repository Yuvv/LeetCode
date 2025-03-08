import java.util.Arrays;
/**
 * 2523-closest-prime-numbers-in-range.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/03/08
 */
public class Solution {
    public int[] closestPrimes(int left, int right) {
        // Sieve of Eratosthenes
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int[] res = new int[]{-1, -1};
        int l = -1, r = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (l < 0) {
                    l = i;
                } else if (r < 0) {
                    r = i;
                } else {
                    l = r;
                    r = i;
                }
                if (l > 0 && r > 0 && r-l < minDiff) {
                    minDiff = r - l;
                    res[0] = l;
                    res[1] = r;

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [11, 13]
        System.out.println(s.closestPrimes(10, 19));
        // [-1, -1]
        System.out.println(s.closestPrimes(4, 6));
    }
}
