/**
 * 2486-append-characters-to-string-to-make-subsequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/03
 */
public class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;
        while (j < t.length() && i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return t.length() - j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.appendCharacters("coaching", "coding"));
        // 0
        System.out.println(s.appendCharacters("abcde", "a"));
        // 5
        System.out.println(s.appendCharacters("z", "abcde"));
    }
}