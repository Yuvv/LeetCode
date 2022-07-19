/*
 * 2243-calculate-digit-sum-of-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/19
 */
public class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();
        while (s.length() > k) {
            sb.delete(0, sb.length());
            for (int i = 0; i < s.length(); i += k) {
                int val = 0;
                for (int j = i; j < s.length() && j < i + k; j++) {
                    val += s.charAt(j) - '0';
                }
                sb.append(val);
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "135"
        System.out.println(s.digitSum("11111222223", 3));
    }
}