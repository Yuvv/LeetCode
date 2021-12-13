/*
 * 1446-consecutive-characters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/13
 */
public class Solution {
    public int maxPower(String s) {
        int max = 1;
        int i = 0;;
        for (int j = 1; j < s.length(); j++) {
            char ch = s.charAt(i);
            while (j < s.length() && s.charAt(j) == ch) {
                j++;
            }
            max = Math.max(max, j - i);
            i = j;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxPower("leetcode"));
        // 5
        System.out.println(s.maxPower("abbcccddddeeeeedcba"));
        // 5
        System.out.println(s.maxPower("triplepillooooow"));
        // 11
        System.out.println(s.maxPower("horaaaaaaaaaaay"));
        // 1
        System.out.println(s.maxPower("tourist"));
    }
}