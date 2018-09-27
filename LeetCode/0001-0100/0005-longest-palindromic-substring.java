class Solution {
    /**
     * 最长子回文串
     * https://leetcode.com/problems/longest-palindromic-substring/description/
     */
    public String longestPalindrome(String s) {
        int sLen = s.length();
        if (sLen < 2) {
            return s;
        }
        int maxBegin = 0, maxEnd = 0;
        int end;
        for (int i = 0; i < sLen; i++) {
            end = sLen - 1;
            if (maxEnd - maxBegin >= end - i) {
                break;
            }
            while (end > i) {
                if (maxEnd - maxBegin >= end - i) {
                    break;
                }
                if (isPalindrome(s, i, end) && end - i > maxEnd - maxBegin) {
                    maxEnd = end;
                    maxBegin = i;
                }
                end--;
            }
        }
        return s.substring(maxBegin, maxEnd + 1);
    }

    boolean isPalindrome(String s, int begin, int end) {
        while (end > begin) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            end--;
            begin++;
        }
        return true;
    }
}