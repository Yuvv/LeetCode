/*
 * 2351-first-letter-to-appear-twice.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/25
 */
public class Solution {
    public char repeatedCharacter(String s) {
        boolean[] appeared = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (appeared[idx]) {
                return ch;
            }
            appeared[idx] = true;
        }
        return '\0';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "c"
        System.out.println(s.repeatedCharacter("abccbaacz"));
    }
}