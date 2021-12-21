/*
 * 1009-complement-of-base-10-integer.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/21
 */
public class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        int base = 1;
        while (n > 0) {
            if ((n & 1) == 0) {
                res |= base;
            }
            base <<=1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.bitwiseComplement(5));
        // 0
        System.out.println(s.bitwiseComplement(7));
        // 5
        System.out.println(s.bitwiseComplement(10));
    }
}