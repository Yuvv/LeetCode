/*
 * 1963-minimum-number-of-swaps-to-make-the-string-balanced.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/18
 */
public class Solution {
    public int minSwaps(String s) {
        int open = 0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                open++;
            } else if (open == 0) {
                close++;
            } else {
                open--;
            }
        }
        return (open + 1) / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minSwaps("][]["));
        // 2
        System.out.println(s.minSwaps("]]][[["));
        // 0
        System.out.println(s.minSwaps("[]"));
    }
}