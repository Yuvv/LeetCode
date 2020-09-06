import java.util.*;

/*
 * 1576-replace-all-s-to-avoid-consecutive-repeating-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/09/07
 */
class Solution {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '?') {
                char replaceChar = 'a';
                char leftChar = i == 0 ? s.charAt(i) : sb.charAt(i - 1);
                char rightChar = s.charAt(Math.min(i + 1, len - 1));
                while (replaceChar == leftChar || replaceChar == rightChar) {
                    replaceChar += 1;
                }
                sb.append(replaceChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.modifyString("?"));
        System.out.println(s.modifyString("?aza"));
        System.out.println(s.modifyString("?az??a?"));
        System.out.println(s.modifyString("?azfsjdk?kla?"));
    }
}