class Solution {
    /**
     * 最短回文串
     * https://leetcode.com/problems/shortest-palindrome/description/
     */
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int begin = 0, end = s.length() - 1;
        while (!palindrome(sb)) {
            sb.insert(begin, s.charAt(end));
            begin++;
            end--;
        }
        return sb.toString();
    }

    boolean palindrome(StringBuilder sb) {
        int begin = 0, end = sb.length() - 1;
        while (end > begin) {
            if (sb.charAt(end) != sb.charAt(begin)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}