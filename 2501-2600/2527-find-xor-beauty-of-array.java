/*
 * 2527-find-xor-beauty-of-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/14
 */
public class Solution {
    public int xorBeauty(int[] nums) {
        int[] arr = new int[29];  // 1 <= n <= 1000000000
        for (int n : nums) {
            int i = 0;
            while (n > 0) {
                if ((n & 1) > 0) {
                    arr[i]++;
                }
                n >>= 1;
                i++;
            }
        }
        int res = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            res <<= 1;
            if (arr[i] % 2 == 1) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.xorBeauty(
            new int[] {1, 4}
        ));
        // 34
        System.out.println(s.xorBeauty(
            new int[] {15,45,20,2,34,35,5,44,32,30}
        ));
    }
}