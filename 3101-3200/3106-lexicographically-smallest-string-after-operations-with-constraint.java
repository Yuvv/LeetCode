/**
 * 3106-lexicographically-smallest-string-after-operations-with-constraint.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/10
 */
public class Solution {
    public String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }
        char[] charr = new char[s.length()];
        int i = 0;
        while (k > 0 && i < s.length()) {
            int chi = s.charAt(i) - 'a';
            if (chi + k >= 26 || chi - k <= 0) {
                charr[i] = 'a';
                k -= Math.min(chi, 26 - chi);
            } else {
                charr[i] = (char)('a' + chi - k);
                k -= k;
            }
            i++;
        }
        while (i < s.length()) {
            charr[i] = s.charAt(i);
            i++;
        }

        return new String(charr);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "aaaz"
        System.out.println(s.getSmallestString("zbbz", 3));
        // "aawcd"
        System.out.println(s.getSmallestString("xaxcd", 4));
        // "lol"
        System.out.println(s.getSmallestString("lol", 0));
    }
}
