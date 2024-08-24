/**
 * 2839-check-if-strings-can-be-made-equal-with-operations-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/24
 */
public class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // s1.length == s2.length == 4
        if (s1.charAt(0) != s2.charAt(0) && s1.charAt(0) != s2.charAt(2)) {
            return false;
        }
        if (s1.charAt(2) != s2.charAt(0) && s1.charAt(2) != s2.charAt(2)) {
            return false;
        }
        if (s1.charAt(1) != s2.charAt(1) && s1.charAt(1) != s2.charAt(3)) {
            return false;
        }
        if (s1.charAt(3) != s2.charAt(3) && s1.charAt(3) != s2.charAt(1)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canBeEqual("abcd", "cdab"));
        // false
        System.out.println(s.canBeEqual("abcd", "dacb"));
    }
}
