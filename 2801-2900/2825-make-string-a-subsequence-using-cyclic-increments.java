/**
 * 2825-make-string-a-subsequence-using-cyclic-increments.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/03/09
 */
public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            while (i < str1.length()
                && str1.charAt(i) != str2.charAt(j)
                && (char)(((str1.charAt(i) + 1) - 'a') % 26 + 'a') != str2.charAt(j)) {
                i++;
            }
            if (i >= str1.length()) {
                break;
            }
            i++;
            j++;
        }
        return j >= str2.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canMakeSubsequence("abc", "ad"));
        // true
        System.out.println(s.canMakeSubsequence("zc", "ad"));
        // false
        System.out.println(s.canMakeSubsequence("ab", "d"));
    }
}
