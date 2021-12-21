/*
 * 1342-number-of-steps-to-reduce-a-number-to-zero.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/21
 */
public class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num ^= 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.numberOfSteps(14));
        // 4
        System.out.println(s.numberOfSteps(8));
        // 12
        System.out.println(s.numberOfSteps(123));
    }
}