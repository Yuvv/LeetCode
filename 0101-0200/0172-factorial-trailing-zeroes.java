/*
 * 0172-factorial-trailing-zeroes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/05
 */

public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        int baseDiv = 5;
        int baseCount = 1;
        while (n >= baseDiv) {
            // deduplication
            result -= (n / baseDiv) * (baseCount - 1);
            // get count of baseDiv
            result += (n / baseDiv) * baseCount;
            baseDiv *= 5;
            baseCount += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 0
        System.out.println(s.trailingZeroes(3));
        // 1
        System.out.println(s.trailingZeroes(5));
        // 0
        System.out.println(s.trailingZeroes(0));
        // 18
        System.out.println(s.trailingZeroes(78));
        // 80
        System.out.println(s.trailingZeroes(325));
        // 249
        System.out.println(s.trailingZeroes(1000));
        // 748
        System.out.println(s.trailingZeroes(3000));
        // 925
        System.out.println(s.trailingZeroes(3713));
    }
}