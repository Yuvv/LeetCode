class Solution {
    /**
     * 判断是否是子串
     * https://leetcode.com/problems/is-subsequence/description/
     */
    public boolean isSubsequence(String s, String t) {
        int fromIndex = 0;
        int index;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), fromIndex);
            if (index == -1) {
                return false;
            }
            fromIndex = index + 1;
        }
        return true;
    }
}