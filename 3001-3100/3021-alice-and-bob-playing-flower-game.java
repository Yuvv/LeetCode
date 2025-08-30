/**
 * 3021-alice-and-bob-playing-flower-game.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/30
 */
public class Solution {
    public long flowerGame(int n, int m) {
        long oddn = n/2;
        long evenn = n/2;
        long oddm = m/2;
        long evenm = m/2;
        if (n%2 == 1) {
            oddn += 1;
        }
        if (m%2 == 1) {
            oddm += 1;
        }
        return (oddn * evenm) + (evenn * oddm);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.flowerGame(3, 2));
        // 0
        System.out.println(s.flowerGame(1, 1));
    }
}