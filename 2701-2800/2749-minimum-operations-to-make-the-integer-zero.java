/**
 * 2749-minimum-operations-to-make-the-integer-zero.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/05
 */
public class Solution {
    private boolean isPossible(long num1, long num2, int ops) {
        num1 -= num2 * ops;
        if (num1 < ops) { // num1 - 2^ops
            return false;
        }
        int cnt = 0;
        while (num1 > 0) {
            if ((num1 & 1) > 0) {
                cnt++;
            }
            num1 >>= 1;
        }
        return cnt <= ops;
    }

    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 0; i <= 60; i++) {
            if (isPossible(num1, num2, i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.makeTheIntegerZero(3, -2));
        // -1
        System.out.println(s.makeTheIntegerZero(5, 7));
    }
}