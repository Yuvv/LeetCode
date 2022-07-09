/*
 * 2063-vowels-of-all-substrings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/09
 */
public class Solution {
    private boolean isVowel(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public long countVowels(String word) {
        // dp[i] means the count sum of all substrings from position i
        long[] dp = new long[word.length() + 1];
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (isVowel(ch)) {
                dp[i] = dp[i + 1] + word.length() - i;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        // so finally, just sum all the results
        long sum = 0L;
        for (long e : dp) {
            sum += e;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countVowels("aba"));
        // 3
        System.out.println(s.countVowels("abc"));
        // 0
        System.out.println(s.countVowels("ltcd"));
    }
}
