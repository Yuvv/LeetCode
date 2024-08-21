import java.util.Arrays;
/**
 * 3121-count-the-number-of-special-characters-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/21
 */
public class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] seenl = new boolean[26];
        int[] lMaxIdx = new int[26];
        boolean[] seenu = new boolean[26];
        int[] uMinIdx = new int[26];
        Arrays.fill(uMinIdx, -1);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                seenl[ch-'a'] = true;
                lMaxIdx[ch-'a'] = i;
            } else {
                seenu[ch-'A'] = true;
                if (uMinIdx[ch-'A'] < 0) {
                    uMinIdx[ch-'A'] = i;
                }
            }
        }
        int len = 0;
        for (int i = 0; i < 26; i++) {
            if (seenl[i] && seenu[i] && lMaxIdx[i] < uMinIdx[i]) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numberOfSpecialChars("aaAbcBC"));
        // 0
        System.out.println(s.numberOfSpecialChars("abc"));
        // 0
        System.out.println(s.numberOfSpecialChars("abBCab"));
    }
}
