class Solution {
    /**
     * 翻转字符串中的单词
     * https://leetcode.com/problems/reverse-words-in-a-string-iii/
     *
     * @param s 句子
     * @return 翻转后的句子
     */
    public String reverseWords(String s) {
        s = s.trim();
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        int begin = 0, end = 1;
        while (end < len) {
            if (s.charAt(end) == ' ') {
                for (int i = end - 1; i >= begin; i--) {
                    sb.append(s.charAt(i));
                }
                sb.append(' ');
                begin = end + 1;
                end += 2;
            } else {
                end++;
            }
        }
        if (begin < len) {
            for (int i = len - 1; i >= begin; i--) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}