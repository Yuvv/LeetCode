/**
 * 2840-check-if-strings-can-be-made-equal-with-operations-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/24
 */
public class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int[] oddcnt = new int[26];
        int[] evencnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                evencnt[s1.charAt(i)-'a']++;
            } else {
                oddcnt[s1.charAt(i)-'a']++;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 0) {
                evencnt[s2.charAt(i)-'a']--;
            } else {
                oddcnt[s2.charAt(i)-'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (oddcnt[i] != 0 || evencnt[i] != 0) {
                return false;
            }
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
