/**
 * 1680-concatenation-of-consecutive-binary-numbers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/17
 */
public class Solution {
    public int concatenatedBinary(int n) {
        long res = 1L;
        for (int i = 2; i <= n; i++) {
            int len = 0;
            int j = i;
            while (j > 0) {
                j >>= 1;
                len++;
            }
            res = ((res << len) + i) % 1000000007L;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.concatenatedBinary(1));
        // 27
        System.out.println(s.concatenatedBinary(3));
        // 505379714
        System.out.println(s.concatenatedBinary(12));
    }
}
