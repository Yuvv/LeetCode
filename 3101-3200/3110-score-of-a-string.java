/**
 * 3110-score-of-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/01
 */
public class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        char lastChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            score += Math.abs(ch - lastChar);
            lastChar = ch;
        }
        return score;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.scoreOfString("hello"));
        // 50
        System.out.println(s.scoreOfString("zaz"));
    }
}