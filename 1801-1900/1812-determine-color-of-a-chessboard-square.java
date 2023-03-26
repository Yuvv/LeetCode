/*
 * 1812-determine-color-of-a-chessboard-square.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/03/26
 */
public class Solution {
    public boolean squareIsWhite(String coordinates) {
        int i = coordinates.charAt(0) - 'a';
        int j = coordinates.charAt(1) - '1';
        if (i % 2 == 0) {
            return j % 2 == 1;
        }
        return j % 2 == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.squareIsWhite("a1"));
        // true
        System.out.println(s.squareIsWhite("h3"));
        // false
        System.out.println(s.squareIsWhite("c7"));
    }
}