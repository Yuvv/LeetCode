/**
 * 2507-smallest-value-after-replacing-with-sum-of-prime-factors.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/18
 */
public class Solution {

    private boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n < 2 || n%2 == 0) {
            return false;
        }
        if (n < 9) {
            return true;
        }
        if (n%3 == 0) {
            return false;
        }
        int r = (int) Math.sqrt(n);
        int f = 5;
        while (f <= r) {
            if (n%f == 0) {
                return false;
            }
            if (n%(f+2) == 0) {
                return false;
            }
            f += 6;
        }
        return true;
    }

    public int smallestValue(int n) {
        while (!isPrime(n)) {
            int on = n;
            int nn = 0;
            for (int f = 2; f <= n; f++) {
                if (isPrime(f)) {
                    while (n%f == 0) {
                        nn += f;
                        n = n/f;
                    }
                }
            }
            if (nn == on) {
                n = on;
                break;
            }
            n = nn;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.smallestValue(15));
        // 3
        System.out.println(s.smallestValue(3));
        // 7
        System.out.println(s.smallestValue(100000));
        // 4
        System.out.println(s.smallestValue(4));
    }
}
