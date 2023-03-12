/*
 * 2582-pass-the-pillow.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/03/12
 */
public class Solution {
    public int passThePillow(int n, int time) {
        int round = time / (n - 1);
        int left = time % (n - 1);
        if (round % 2 == 0) {
            return left + 1;
        } else {
            return n - left;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.passThePillow(4, 5));
        // 3
        System.out.println(s.passThePillow(3, 2));
        // 2
        System.out.println(s.passThePillow(2, 341));
    }
}
