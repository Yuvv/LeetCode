/*
 * 2108-find-first-palindromic-string-in-the-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/20
 */
public class Solution {
    public boolean isPlindromic(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPlindromic(s)) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "ada"
        System.out.println(s.firstPalindrome(new String[] {"abc","car","ada","racecar","cool"}));
        // "racecar"
        System.out.println(s.firstPalindrome(new String[] {"notapalindrome","racecar"}));
        // ""
        System.out.println(s.firstPalindrome(new String[] {"def", "ghi"}));
    }
}