import java.util.Arrays;

/**
 * 1657-determine-if-two-strings-are-close
 *
 * @date 2024/1/14
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            a1[word1.charAt(i)-'a']++;
            a2[word2.charAt(i)-'a']++;
        }
        for (int i = 0; i < a1.length; i++) {
            if ((a1[i] == 0) != (a2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.closeStrings("abc", "bca"));
        // false
        System.out.println(s.closeStrings("a", "ca"));
        // true
        System.out.println(s.closeStrings("cabbba", "abbccc"));

    }
}
