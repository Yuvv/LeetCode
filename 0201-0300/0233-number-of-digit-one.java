import java.util.*;
/*
 * 0233-number-of-digit-one.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/10
 */
public class Solution {

    private int countDigitOne(int n) {
        int counter = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            counter += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return counter;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countDigitOne(13));
        // 5
        System.out.println(s.countDigitOne(12));
        // 4
        System.out.println(s.countDigitOne(11));
        // 0
        System.out.println(s.countDigitOne(0));
    }
}