/**
 * 3174-clear-digits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/15
 */
public class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                sb.append(ch);
            } else {
                sb.deleteCharAt(sb.length() - 1); // Remove the last character if it's a digit
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "abc"
        System.out.println(s.clearDigits("abc"));
        // ""
        System.out.println(s.clearDigits("cb34"));
    }
}