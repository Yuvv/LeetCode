/**
 * 2396-strictly-palindromic-number
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/03
 */
public class Solution {
    public boolean isStrictlyPalindromic(int n) {
        // the number in base (n-2) is always 12, which is not palindromic
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.isStrictlyPalindromic(9));
        // false
        System.out.println(s.isStrictlyPalindromic(4));
    }
}
