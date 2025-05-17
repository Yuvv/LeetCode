import java.util.*;
/**
 * 2901-longest-unequal-adjacent-groups-subsequence-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/17
 */
public class Solution {

    private int getHanDis(String[] words, int[][] handis, int i, int j) {
        if (handis[i][j-i] != -1) {
            return handis[i][j-i];
        }
        String a = words[i];
        String b = words[j];
        if (a.length() != b.length()) {
            return handis[i][j-i] = Integer.MAX_VALUE;
        }
        int c = 0;
        for (int k = 0; k < a.length(); k++) {
            if (a.charAt(k) != b.charAt(k)) {
                c++;
            }
        }
        handis[i][j-i] = c;
        return c;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int[][] handis = new int[groups.length][];
        for (int i = 0; i < groups.length; i++) {
            handis[i] = new int[groups.length-i];
            handis[i][0] = 0;
            for (int j = 1; j < handis[i].length; j++) {
                handis[i][j] = -1;
            }
        }

        int[] dp = new int[groups.length];
        dp[groups.length-1] = 1;
        for (int i = groups.length-2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i+1; j < groups.length+1-dp[i]; j++) {
                if (groups[i] != groups[j] && getHanDis(words, handis, i, j) == 1) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maxIdx = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<String> result = new ArrayList<>();
        result.add(words[maxIdx]);
        for (int i = maxIdx+1; i < groups.length; i++) {
            if (dp[i] != dp[maxIdx]-1) {
                continue;
            }
            if (groups[i] != groups[maxIdx] && getHanDis(words, handis, maxIdx, i) == 1) {
                result.add(words[i]);
                maxIdx = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["bab","cab"]
        System.out.println(s.getWordsInLongestSubsequence(
            new String[]{"bab","dab","cab"}, new int[]{1,2,2}
        ));
        // ["a","b","c","d"]
        System.out.println(s.getWordsInLongestSubsequence(
            new String[]{"a","b","c","d"}, new int[]{1,2,3,4}
        ));
        // ["dc","dd","da"]
        System.out.println(s.getWordsInLongestSubsequence(
            new String[]{"bad","dc","bc","ccd","dd","da","cad","dba","aba"},
            new int[]{9,7,1,2,6,8,3,7,2}
        ));
    }
}