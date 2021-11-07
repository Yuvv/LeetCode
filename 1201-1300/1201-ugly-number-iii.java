/*
 * 1201-ugly-number-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/07
 */
public class Solution {
    public int nthUglyNumber_lte(int n, int a, int b, int c) {
        long ia = 0, ib = 0, ic = 0;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.min(ia + a, Math.min(ib + b, ic + c));
            if (res == ia + a) {
                ia = res;
            }
            if (res == ib + b) {
                ib = res;
            }
            if (res == ic + c) {
                ic = res;
            }
        }
        return (int) res;
    }

    public long getLcm(long a, long b) {
        long mx = a, mn = b;
        if (a < b) {
            mx = b;
            mn = a;
        }
        while (mn != 0) {
            long tmp = mn;
            mn = mx % mn;
            mx = tmp;
        }
        return (a * b) / mx;
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = getLcm(a, b);
        long ac = getLcm(a, c);
        long bc = getLcm(b, c);
        long abc = getLcm(a, bc);

        long left = 1;
        long right = 2000000001;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long begin = System.nanoTime();
        // 4
        System.out.println(s.nthUglyNumber(3, 2, 3, 5));
        // 6
        System.out.println(s.nthUglyNumber(4, 2, 3, 4));
        // 1
        System.out.println(s.nthUglyNumber(1, 1, 1, 1));
        // 10
        System.out.println(s.nthUglyNumber(5, 2, 11, 13));
        // 1999999984
        System.out.println(s.nthUglyNumber(1000000000, 2, 217983653, 336916467));

        System.out.println("total: " + (System.nanoTime() - begin));
    }
}