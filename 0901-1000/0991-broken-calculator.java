/*
 * 0991-broken-calculator.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/23
 */
public class Solution {
    public int brokenCalc(int startValue, int target) {
        if (target <= startValue) {
            return startValue - target;
        }

        int half = (target + 1) / 2;
        if (half >= startValue) {
            // note: `target % 2` means if target is odd,
            //       we need do subtract 1 after multiply by 2
            return target % 2 + 1 + brokenCalc(startValue, half);
        }
        return 1 + Math.min(startValue - half + target % 2, 2 * startValue - target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.brokenCalc(2, 3));
        // 2
        System.out.println(s.brokenCalc(5, 8));
        // 3
        System.out.println(s.brokenCalc(3, 10));
        // 1023
        System.out.println(s.brokenCalc(1024, 1));
        // 34
        System.out.println(s.brokenCalc(68, 71));
    }
}