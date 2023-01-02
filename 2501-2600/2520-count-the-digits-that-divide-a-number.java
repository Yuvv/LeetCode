/*
 * 2520-count-the-digits-that-divide-a-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/02
 */
public class Solution {
    public int countDigits(int num) {
        int n = num;
        int cnt = 0;
        while (n > 0) {
            int x = n % 10;
            n /= 10;
            if (x != 0 && num % x == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countDigits(1248));
    }
}