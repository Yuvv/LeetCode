/*
 * 1137-n-th-tribonacci-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/24
 */
public class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            int tn = 0, tn1 = 1, tn2 = 1;
            int tmp = 0;
            for (int i = 3; i <= n; i++) {
                tmp = tn + tn1 + tn2;
                tn = tn1;
                tn1 = tn2;
                tn2 = tmp;
            }
            return tmp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.tribonacci(4));
        // 1389537
        System.out.println(s.tribonacci(25));
    }
}