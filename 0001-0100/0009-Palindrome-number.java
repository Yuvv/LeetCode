/*
 * 0009-Palindrome-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2018/04/11
 */
public class Solution {
    /**
     * 回文数字
     * https://leetcode.com/problems/palindrome-number/description/
     */
    public boolean isPalindrome_reverse_string(int x) {
        return new StringBuilder().append(x).reverse().toString().equals("" + x);
    }

    public boolean isPalindrome_full_calc(int x) {
        if (x < 0) {
            return false;
        }
        long rx = 0L;
        long y = (long) x;
        while (y > 0) {
            rx = rx * 10L + y % 10L;
            y /= 10L;
        }
        return rx == x;
    }

    // half calc
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }

        int rx = 0;
        while (x > rx) {
            rx = rx * 10 + x % 10;
            x /= 10;
        }
        return rx == x || x == rx / 10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isPalindrome(121));
        // false
        System.out.println(s.isPalindrome(-121));
        // false
        System.out.println(s.isPalindrome(10));
    }
}