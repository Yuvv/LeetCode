/**
 * 3084-count-substrings-starting-and-ending-with-given-character.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/24
 */
public class Solution {
    public long countSubstrings(String s, char c) {
        long cnt = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cnt++;
            }
        }
        return (cnt + 1) * cnt / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countSubstrings("abada", 'a'));
    }
}