/**
 * 3783-mirror-distance-of-an-integer.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/04/18
 */
public class Solution {
    public int mirrorDistance(int n) {
        int mirror = 0;
        int originN = n;
        while (n > 0) {
            mirror = mirror * 10 + n % 10;
            n /= 10;
        }
        return Math.abs(originN - mirror);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 27
        System.out.println(s.mirrorDistance(25));
        // 9
        System.out.println(s.mirrorDistance(10));
        // 0
        System.out.println(s.mirrorDistance(7));
    }
}