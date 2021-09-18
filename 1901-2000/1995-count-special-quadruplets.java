/*
 * 1995-count-special-quadruplets.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/18
 */
public class Solution {
    public int countQuadruplets(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int n = k + 1; n < nums.length; n++) {
                        if (nums[n] == sum) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.countQuadruplets(new int[] {1, 2, 3, 6}));
        // 0
        System.out.println(s.countQuadruplets(new int[] {3, 3, 6, 4, 5}));
        // 4
        System.out.println(s.countQuadruplets(new int[] {1, 1, 1, 3, 5}));
    }
}