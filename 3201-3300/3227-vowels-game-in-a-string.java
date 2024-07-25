/**
 * 3227-vowels-game-in-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/25
 */
public class Solution {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.doesAliceWin("leetcoder"));
        // false
        System.out.println(s.doesAliceWin("bbcd"));
    }
}
