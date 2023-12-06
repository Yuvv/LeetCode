/**
 * 1716-calculate-money-in-leetcode-bank
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/06
 */
public class Solution {
    public static final int[] DAY_SAVES = new int[] {
            0, 1, 3, 6, 10, 15, 21, 28
    };

    public int totalMoney(int n) {
        int x = n / 7;
        int y = n % 7;
        int total = 0;
        int base = 0;

        if (y > 0) {
            total += DAY_SAVES[y] + x * y;
        }
        while (x > 0) {
            total += DAY_SAVES[7] + base;
            base += 7;
            x--;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 10
        System.out.println(s.totalMoney(4));
        // 37
        System.out.println(s.totalMoney(10));
        // 96
        System.out.println(s.totalMoney(20));
    }
}
