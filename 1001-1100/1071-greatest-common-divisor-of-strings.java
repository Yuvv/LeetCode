/*
 * 1071-greatest-common-divisor-of-strings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/05
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        for (int len = 1; len <= str2.length(); len++) {
            if (str2.length() % len != 0) {
                continue;
            }
            int gcdLen = str2.length() / len;
            if (str1.length() % gcdLen != 0) {
                continue;
            }
            String gcdStr = str2.substring(0, gcdLen);
            if (isDivided(str2, gcdStr) && isDivided(str1, gcdStr)) {
                return gcdStr;
            }
        }
        return "";
    }

    public boolean isDivided(String ss, String tt) {
        for (int i = 0; i < ss.length(); ) {
            for (int j = 0; j < tt.length(); j++, i++) {
                if (ss.charAt(i) != tt.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "ABC"
        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
        // "AB"
        System.out.println(s.gcdOfStrings("ABABAB", "ABAB"));
    }
}