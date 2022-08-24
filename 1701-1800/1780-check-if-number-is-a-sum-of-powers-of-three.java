/*
 * 1780-check-if-number-is-a-sum-of-powers-of-three.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/24
 */
public class Solution {
    public boolean checkPowersOfThree(int n) {
        int[] ternary = new int[20];
        for (int i = 0; i < ternary.length && n > 0; i++) {
            ternary[i] = n % 3;
            n /= 3;
            if (ternary[i] == 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkPowersOfThree(12));
        // true
        System.out.println(s.checkPowersOfThree(91));
        // false
        System.out.println(s.checkPowersOfThree(21));
    }
}