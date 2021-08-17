/*
 * 0680-valid-palindrome-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/17
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (a != b) {
                if (a == s.charAt(j - 1)) {
                    if (isPalindrome(s, i + 1, j - 2)) {
                        return true;
                    }
                }
                if (s.charAt(i + 1) == b) {
                    if (isPalindrome(s, i + 2, j - 1)) {
                        return true;
                    }
                }
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
         // true
        System.out.println(s.validPalindrome("aba"));
        // true
        System.out.println(s.validPalindrome("abca"));
        //  false
        System.out.println(s.validPalindrome("abc"));
        // false
        System.out.println(s.validPalindrome("ebcbbececabbacecbbcbe"));
    }
}