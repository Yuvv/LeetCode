/**
 * 3191-minimum-operations-to-make-binary-array-elements-equal-to-one-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/23
 */
public class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                cnt++;
                nums[i] = 1;
                nums[i+1] = 1 - nums[i+1];
                nums[i+2] = 1 - nums[i+2];
            }
        }
        if (nums[nums.length-1] == 1 && nums[nums.length-2] == 1) {
            return cnt;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minOperations(new int[]{0,1,1,1,0,0}));
        // -1
        System.out.println(s.minOperations(new int[]{0,1,1,1}));
    }
}