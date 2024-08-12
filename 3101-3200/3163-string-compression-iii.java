/**
 * 3163-string-compression-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/12
 */
public class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < word.length()) {
            char ch = word.charAt(i);
            int cnt = 1;
            i++;
            while (i < word.length() && cnt < 9 && word.charAt(i) == ch) {
                i++;
                cnt++;
            }
            sb.append(cnt).append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "1a1b1c1d1e"
        System.out.println(s.compressedString("abcde"));
        // "9a5a2b"
        System.out.println(s.compressedString("aaaaaaaaaaaaaabb"));
    }
}
