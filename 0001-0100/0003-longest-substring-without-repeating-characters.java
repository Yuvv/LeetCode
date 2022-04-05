/*
 * 0003-longest-substring-without-repeating-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2018/06/18
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        int lastIndex = 0;
        char curChar;
        int duplicatedIndex;

        // 通过滑动窗口，找到么有重复的最大长度
        for (int i = 1; i < s.length(); i++) {
            curChar = s.charAt(i);
            duplicatedIndex = -1;
            for (int j = lastIndex; j < i; j++) {
                if (curChar == s.charAt(j)) {
                    duplicatedIndex = j;
                    break;
                }
            }
            if (duplicatedIndex != -1) {
                maxLen = Math.max(maxLen, i - lastIndex);
                lastIndex = duplicatedIndex + 1;
            } else {
                maxLen = Math.max(maxLen, i - lastIndex + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        // 3
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}