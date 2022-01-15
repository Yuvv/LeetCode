/*
 * 1876-substrings-of-size-three-with-distinct-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/15
 */
public class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 2; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = s.charAt(i - 1);
            char c = s.charAt(i - 2);
            if (a != b && a != c && b != c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.countGoodSubstrings("xyzzaz"));
        // 4
        System.out.println(s.countGoodSubstrings("aababcabc"));
    }
}