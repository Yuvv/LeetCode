import java.util.Set;
import java.util.HashSet;

/**
 * 1930-unique-length-3-palindromic-subsequences
 *
 * @author Yuvv<yuvv_th@outlook.com>
 * @date 2023/11/19
 */
public class Solution {
    public int countPalindromicSubsequence(String s) {
        int cnt = 0;
        Set<Character> findSet = new HashSet<>(26);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (findSet.contains(c)) {
                continue;
            }
            findSet.add(c);
            int j;
            for (j = s.length() - 1; j > i + 1; j--) {
                if (c == s.charAt(j)) {
                    break;
                }
            }
            if (j > i + 1) {
                Set<Character> subset = new HashSet<>(26);
                for (int k = i + 1; k < j && subset.size() < 26; k++) {
                    char kc = s.charAt(k);
                    subset.add(kc);
                }
                cnt += subset.size();
            }
            if (findSet.size() >= 26) {
                break;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.countPalindromicSubsequence("aabca"));
        // 0
        System.out.println(s.countPalindromicSubsequence("adc"));
        // 4
        System.out.println(s.countPalindromicSubsequence("bbcbaba"));
    }
}
