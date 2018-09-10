class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;  // "" == ""
        }
        boolean eq;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            eq = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                return i;
            }
        }
        return -1;
    }
}