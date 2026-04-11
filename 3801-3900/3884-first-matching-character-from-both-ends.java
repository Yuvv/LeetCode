/**
 * 3884-first-matching-character-from-both-ends.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/4/11
 */
public class Solution {
    public int firstMatchingIndex(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                return i;
            }
            i++;
            j--;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.fistMatchingIndex("abcacbd"));
        // 1
        System.out.println(s.fistMatchingIndex("abc"));
        // -1
        System.out.println(s.fistMatchingIndex("abcdab"));
    }
}