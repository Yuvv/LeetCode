/**
 * 3010-divide-an-array-into-subarrays-with-minimum-cost-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/11
 */
public class Solution {
    public int minimumCost(int[] nums) {
        int min1 = nums[1];
        int min2 = nums[2];
        if (min1 > min2) {
            min1 = nums[2];
            min2 = nums[1];
        }
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return nums[0] + min1 + min2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.minimumCost(new int[] {1,2,3,12}));
        // 12
        System.out.println(s.minimumCost(new int[] {5,4,3}));
        // 12
        System.out.println(s.minimumCost(new int[] {10,3,1,1}));
    }
}
