/*
 * 1328-break-a-palindrome.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/23
 */
public class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palindrome.length(); i++) {
            char ch = palindrome.charAt(i);
            if (ch != 'a' && i != palindrome.length() - 1 - i) {
                sb.append('a');
                sb.append(palindrome.substring(i + 1));
                return sb.toString();
            } else {
                sb.append(ch);
            }
        }
        sb.deleteCharAt(palindrome.length() - 1);
        sb.append('b');
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "aaccba"
        System.out.println(s.breakPalindrome("abccba"));
        // "a"
        System.out.println(s.breakPalindrome(""));
        // "ab"
        System.out.println(s.breakPalindrome("aa"));
        // "abb"
        System.out.println(s.breakPalindrome("aba"));
    }
}