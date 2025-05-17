import java.util.*;
/**
 * 2900-longest-unequal-adjacent-groups-subsequence-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/17
 */
public class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int lastGroup = -1;
        for (int i = 0; i < words.length; i++) {
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["e","b"]
        System.out.println(s.getLongestSubsequence(
            new String[]{"e","a","b"}, new int[]{0,0,1}
        ));
        // ["a","b","c"]
        System.out.println(s.getLongestSubsequence(
            new String[]{"a","b","c","d"}, new int[]{1,0,1,1}
        ));
    }
}