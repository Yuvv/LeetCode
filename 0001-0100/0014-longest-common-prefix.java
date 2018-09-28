class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int idx = 0;
        String s = "";
        char c;
        while (idx < strs[0].length()) {
            c = strs[0].charAt(idx);
            for (int i = 1; i<strs.length; i++) {
                if (idx >= strs[i].length()) {
                    return s;
                }
                if (strs[i].charAt(idx) != c) {
                    return s;
                }
            }
            s += c;
            idx++;
        }
        return s;
    }
}