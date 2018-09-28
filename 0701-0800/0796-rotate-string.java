class Solution {
    /**
     * 翻转字符串，从某一个位置移动后和原字符串相等。
     * https://leetcode.com/problems/rotate-string/description/
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int index = B.length();
        do {
            if (equal(A, B, index)) {
                return true;
            }
            index = B.lastIndexOf(A.charAt(0), index - 1);
        } while (index > 0);
        return false;
    }

    boolean equal(String a, String b, int offset) {
        int length = a.length();
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt((i + offset) % length)) {
                return false;
            }
        }
        return true;
    }
}