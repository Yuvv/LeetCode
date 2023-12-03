/**
 * 2745-construct-the-longest-new-string
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/03
 */
public class Solution {
    public int longestString(int x, int y, int z) {
        return (Math.min(x, y) * 2 + ((x == y) ? 0 : 1) + z) * 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.longestString(2, 5, 1));
        // 176
        System.out.println(s.longestString(20, 20, 48));
        // 168
        System.out.println(s.longestString(47, 31, 21));
    }
}
