import java.util.*;
/**
 * 2375-construct-smallest-number-from-di-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/19
 */
public class Solution {
    public String smallestNumber(String pattern) {
        char[] resList = new char[pattern.length() + 1];
        int resIdx = 0;
        int[] stack = new int[pattern.length() + 1];
        int stackIdx = 0;
        for (int i = 0; i < resList.length; i++) {
            stack[stackIdx++] = i + 1;
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (stackIdx > 0) {
                    resList[resIdx++] = (char) ('0' + stack[stackIdx - 1]);
                    stackIdx--;
                }
            }
        }
        return new String(resList);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "123549876"
        System.out.println(s.smallestNumber("IIIDIDDD"));
        // "4321"
        System.out.println(s.smallestNumber("DDD"));
    }
}
