class Solution {
    /**
     * 字符串转换为小写
     * https://leetcode.com/problems/to-lower-case/description/
     */
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        char chr;
        for (int i = 0; i < str.length(); i++) {
            chr = str.charAt(i);
            if (chr <= 'Z' && chr >= 'A') {
                chr += 32;
            }
            sb.append(chr);
        }
        return sb.toString();
    }
}