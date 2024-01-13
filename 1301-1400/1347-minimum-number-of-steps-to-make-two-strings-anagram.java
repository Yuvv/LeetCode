import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 1347-minimum-number-of-steps-to-make-two-strings-anagram
 *
 * @date 2024/1/13
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int minSteps(String s, String t) {
        int[][] cnt = new int[2][26];
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            cnt[0][chs-'a'] += 1;
            cnt[1][cht-'a'] += 1;
        }
        //
        int res = 0;
        for (int i = 0; i < 26; i++) {
            int diff = cnt[1][i] - cnt[0][i];
            if (diff > 0) {
                res += diff;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minSteps("bab", "aba"));
        // 5
        System.out.println(s.minSteps("leetcode", "practice"));
        // 0
        System.out.println(s.minSteps("anagram", "mangaar"));
    }
}
