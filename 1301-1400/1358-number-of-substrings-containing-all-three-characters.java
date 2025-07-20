/**
 * 1358-number-of-substrings-containing-all-three-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/20
 */
public class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] count = new int[3];
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += s.length() - j;
                count[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 10
        System.out.println(s.numberOfSubstrings("abcabc"));
        // 3
        System.out.println(s.numberOfSubstrings("aaacb"));
        // 1
        System.out.println(s.numberOfSubstrings("abc"));
    }
}