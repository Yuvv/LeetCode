/*
 * 1822-sign-of-the-product-of-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/17
 */
public class Solution {
    public int arraySign(int[] nums) {
        int minusCount = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                minusCount++;
            }
        }
        if (minusCount % 2 == 0) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(new int[]{-1, -2, -3, -4, 3, 2, 1});
    }
}