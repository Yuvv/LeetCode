/**
 * 3514-process-string-with-special-operations-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/17
 */
public class Solution {
    public char processStr(String s, long k) {
        long[] lenarr = new long[s.length()];
        long len = 0L;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case '#':  // duplicate
                len *= 2;
                break;
            case '*':  // remove last
                if (len > 0) {
                    len--;
                }
                break;
            case '%': // reverse
                break;
            default:  // append
                len++;
                break;
            }
            lenarr[i] = len;
        }
        if (lenarr[s.length()-1] <= k) {
            return '.';
        }
        // walk backward
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            switch (ch) {
            case '#': // duplicates, 'k' should be in the module of last length
                k = k % (lenarr[i]/2);
                break;
            case '*': // remove last, won't change 'k' position
                break;
            case '%': // reverse, 'k' should be in the mirror position
                k = lenarr[i] - 1 - k;
                break;
            default:
                // normal character, k not change.
                // if 'k' equals the length, then the character is just the result.
                if (k+1 == lenarr[i]) {
                    return ch;
                }
                break;
            }
        }
        return '.';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "a"
        System.out.println(s.processStr("a#b%*", 1));
        // "d"
        System.out.println(s.processStr("cd%#*#", 3));
        // "."
        System.out.println(s.processStr("z*#", 0));
    }
}