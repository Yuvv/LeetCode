/*
 * 2109-adding-spaces-to-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/20
 */
public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && spaces[j] == i) {
                sb.append(' ');
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "Leetcode Helps Me Learn"
        System.out.println(s.addSpaces("LeetcodeHelpsMeLearn", new int[] {8,13,15}));
        // "i code in py thon"
        System.out.println(s.addSpaces("icodeinpython", new int[] {1,5,7,9}));
        // " s p a c i n g"
        System.out.println(s.addSpaces("spacing", new int[] {0,1,2,3,4,5,6}));
    }
}