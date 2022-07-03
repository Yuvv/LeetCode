/*
 * 2303-calculate-amount-paid-in-taxes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/03
 */
public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0D;
        int prevUpper = 0;
        for (int[] bracket : brackets) {
            res += (Math.min(income, bracket[0]) - prevUpper) * bracket[1] / 100D;
            prevUpper = bracket[0];
            if (bracket[0] >= income) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2.65
        System.out.println(s.calculateTax(
            new int[][] {{3,50}, {7,10}, {12,25}}, 10
        ));
    }
}