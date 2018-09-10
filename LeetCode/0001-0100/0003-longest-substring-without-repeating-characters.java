class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        int lastIndex = 0;
        char curChar;
        int duplicatedIndex;

        for (int i=1; i<s.length(); i++) {
            curChar = s.charAt(i);
            duplicatedIndex = -1;
            for (int j=lastIndex; j<i; j++) {
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
}