/*
 * 1922-count-good-numbers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/10
 */
public class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007L;
        long result = n % 2 == 0 ? 1L : 5L;

        long base = 20L;
        long time = n / 2L;
        while (time > 0) {
            if (time % 2L > 0) {
                result *= base;
                result %= mod;
            }
            time /= 2L;
            base = base * base % mod;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 564908303
        System.out.println(s.countGoodNumbers(50L));
        // 5
        System.out.println(s.countGoodNumbers(1L));
        // 400
        System.out.println(s.countGoodNumbers(4L));
        // -
        System.out.println(s.countGoodNumbers(806166225460393L));

    }
}