/**
 * 3304-find-the-k-th-character-in-string-game-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/05
 */
public class Solution {
    // 1 <= k <= 500
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while (sb.length() < k) {
            int len = sb.length();
            for (int i = 0; i < len; i++) {
                char c = sb.charAt(i);
                if (c == 'z') {
                    sb.append('a');
                } else {
                    sb.append((char) (c + 1));
                }
            }
        }
        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "b"
        System.out.println(s.kthCharacter(5));
        // "c"
        System.out.println(s.kthCharacter(10));
    }
}