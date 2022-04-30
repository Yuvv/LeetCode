/*
 * 2177-find-three-consecutive-integers-that-sum-to-a-given-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/30
 */
public class Solution {
    public long[] sumOfThree(long num) {
        long x = num / 3L;
        if (x * 3L == num) {
            return new long[] {x - 1, x, x + 1};
        }
        return new long[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [10,11,12]
        System.out.println(s.sumOfThree(33));
    }
}