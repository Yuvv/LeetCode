/**
 * 1935-maximum-number-of-words-you-can-type.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/20
 */
public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (int i = 0; i < brokenLetters.length(); i++) {
            broken[brokenLetters.charAt(i)-'a'] = true;
        }
        int cnt = 0;
        int i = 0;
        while (i < text.length()) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                cnt++;
            } else if (broken[ch-'a']) {
                // skip next space
                while (i < text.length() && text.charAt(i) != ' ') {
                    i++;
                }
            }
            i++;
        }
        if (i == text.length()) { // last word
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.canBeTypedWords(
            "hello world", "ad"
        ));
        // 1
        System.out.println(s.canBeTypedWords(
            "leet code", "lt"
        ));
        // 0
        System.out.println(s.canBeTypedWords(
            "leet code", "e"
        ));
    }
}