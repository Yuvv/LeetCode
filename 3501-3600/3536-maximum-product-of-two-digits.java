/**
 * 3536-maximum-product-of-two-digits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/22
 */
public class Solution {
    public int maxProduct(int n) {
        int m1 = 0, m2 = 0;
        while (n > 0) {
            int x = n % 10;
            n /= 10;
            if (x > m1) {
                m2 = m1;
                m1 = x;
            } else if (x > m2) {
                m2 = x;
            }
        }
        return m1*m2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxProduct(13));
    }
}