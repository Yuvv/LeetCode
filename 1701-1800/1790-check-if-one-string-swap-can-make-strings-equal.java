/**
 * 1790-check-if-one-string-swap-can-make-strings-equal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/15
 */
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] diff = new int[2];
        int k = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (k >= 2) {
                    return false; // More than two differences
                }
                diff[k++] = i; // Store the index of the difference
            }
        }
        if (k == 0) {
            return true; // Strings are already equal
        }
        if (k == 1) {
            return false; // Only one difference, cannot swap to make equal
        }
        return s1.charAt(diff[0]) == s2.charAt(diff[1]) && s1.charAt(diff[1]) == s2.charAt(diff[0]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.areAlmostEqual("bank", "kanb"));
        // false
        System.out.println(s.areAlmostEqual("attack", "defend"));
        // true
        System.out.println(s.areAlmostEqual("kelb", "kelb"));
    }
}