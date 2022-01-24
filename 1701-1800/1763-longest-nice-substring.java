/*
 * 1763-longest-nice-substring.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/24
 */
public class Solution {
    public String longestNiceSubstring(String s) {
        String ss = "";
        for (int i = 0; i < s.length() - ss.length(); i++) {
            for (int j = s.length(); j - i > ss.length(); j--) {
                String candidate = s.substring(i, j);
                if (isOk(candidate) && candidate.length() > ss.length()) {
                    ss = candidate;
                    break;
                }
            }
        }
        return ss;
    }

    boolean isOk(String sss) {
        int lo = 0;
        int up = 0;
        for (int i = 0; i < sss.length(); i++) {
            char ch = sss.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lo |= 1 << (ch - 'a' + 1);
            }
            else if (ch >= 'A' && ch <= 'Z') {
                up |= 1 << (ch - 'A' + 1);
            }
        }

        return (lo ^ up) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "aAa"
        System.out.println(s.longestNiceSubstring("YazaAay"));
        // "Bb"
        System.out.println(s.longestNiceSubstring("Bb"));
        // ""
        System.out.println(s.longestNiceSubstring("c"));
    }
}