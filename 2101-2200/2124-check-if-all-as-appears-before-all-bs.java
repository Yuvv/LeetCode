/*
 * 2124-check-if-all-as-appears-before-all-bs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/06
 */
public class Solution {
    public boolean checkString(String s) {
        int firstB = s.indexOf('b');
        if (firstB < 0) {
            return true;
        }
        return s.indexOf('a', firstB + 1) < firstB;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkString("aaabbb"));
        // false
        System.out.println(s.checkString("abab"));
    }
}