/*
 * 2220-minimum-bit-flips-to-convert-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/16
 */
public class Solution {
    public int minBitFlips(int start, int goal) {
        int val = start ^ goal;
        int cnt = 0;
        while (val > 0) {
            cnt += val & 1;
            val >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minBitFlips(10, 7));
        // 3
        System.out.println(s.minBitFlips(3, 4));
    }
}