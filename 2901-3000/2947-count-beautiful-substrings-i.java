/**
 * 2947-count-beautiful-substrings-i
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/19
 */
public class Solution {
    public int beautifulSubstrings(String s, int k) {
        int[] prefixSum = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                prefixSum[i] = prefixSum[i - 1];
            }
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                prefixSum[i]++;
            }
        }

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int pVowels = 0;
            if (i > 0) {
                pVowels = prefixSum[i - 1];
            }
            for (int j = i; j < s.length(); j++) {
                int vowels = prefixSum[j] - pVowels;
                int consonants = j - i + 1 - vowels;
                if (vowels == consonants && vowels * consonants % k == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.beautifulSubstrings("baeyh", 2));
        // 3
        System.out.println(s.beautifulSubstrings("abba", 1));
        // 0
        System.out.println(s.beautifulSubstrings("bcdf", 1));
    }
}
