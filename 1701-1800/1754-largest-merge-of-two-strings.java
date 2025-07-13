/**
 * 1754-largest-merge-of-two-strings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/13
 */
public class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(j);
            if (ch1 > ch2) {
                sb.append(ch1);
                i++;
            } else if (ch1 < ch2) {
                sb.append(ch2);
                j++;
            } else {
                int ii = i;
                int jj = j;
                while (ii < word1.length() && jj < word2.length() && word1.charAt(ii) == word2.charAt(jj)) {
                    ii++;
                    jj++;
                }
                if (ii < word1.length() && jj < word2.length()) {
                    if (word1.charAt(ii) > word2.charAt(jj)) {
                        sb.append(ch1);
                        i++;
                    } else {
                        sb.append(ch2);
                        j++;
                    }
                } else if (ii < word1.length()) {
                    sb.append(ch1);
                    i++;
                } else {
                    sb.append(ch2);
                    j++;
                }
            }
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "cbcabaaaaa"
        System.out.println(s.largestMerge("cabaa", "bcaaa"));
        // "abdcabcabcaba"
        System.out.println(s.largestMerge("abcabc", "abdcaba"));
    }
}