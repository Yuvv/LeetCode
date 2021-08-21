/*
 * 0696-count-binary-substrings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/21
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int sLen = s.length();
        if (sLen == 0) {
            return 0;
        }
        int total = 0;
        int lastCount = 0, curCount = 0;

        for (int i = 0; i < sLen; /* noting to do */) {
            char curChar = s.charAt(i);
            curCount = 0;
            while (i < sLen && s.charAt(i) == curChar) {
                i++;
                curCount++;
            }
            total += Math.min(lastCount, curCount);
            // switch last, current
            lastCount = curCount;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countBinarySubstrings("00110011"));
        // 4
        System.out.println(s.countBinarySubstrings("10101"));
        // 4
        System.out.println(s.countBinarySubstrings("101011000"));
    }
}