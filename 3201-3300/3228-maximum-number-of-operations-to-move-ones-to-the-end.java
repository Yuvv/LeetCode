/**
 * 3228-maximum-number-of-operations-to-move-ones-to-the-end.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/24
 */
public class Solution {
    public int maxOperations(String s) {
        int total = 0;
        int cnt = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                total += cnt;
            }
            while (i < s.length() && s.charAt(i) == '0') {
                i++;
            }
            while (i < s.length() && s.charAt(i) == '1') {
                cnt++;
                i++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maxOperations("1001101"));
        // 0
        System.out.println(s.maxOperations("00111"));
    }
}
