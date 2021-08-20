/*
 * 0693-binary-number-with-alternating-bits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/20
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n & 0x01;
        int y;
        n >>= 1;
        while (n > 0) {
            y = n & 0x01;
            if ((x ^ y) == 0) {
                return false;
            }
            x = y;
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.hasAlternatingBits(5));
        // false
        System.out.println(s.hasAlternatingBits(7));
        // false
        System.out.println(s.hasAlternatingBits(11));
        // true
        System.out.println(s.hasAlternatingBits(10));
    }
}