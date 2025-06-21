/**
 * 2579-count-total-number-of-colored-cells.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/21
 */
public class Solution {
    public long coloredCells(int n) {
        // a(n) = a(n-1) + 4 * (n - 1)
        // a(1) = 1
        long res = 1L;
        for (int i = 0; i < n; i++) {
            res += 4 * i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.coloredCells(1));
        // 5
        System.out.println(s.coloredCells(2));
        // 13
        System.out.println(s.coloredCells(3));
        // 25
        System.out.println(s.coloredCells(4));
        // 41
        System.out.println(s.coloredCells(5));
    }
}