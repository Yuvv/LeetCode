/*
 * 2369-check-if-there-is-a-valid-partition-for-the-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/08/13
 */
public class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        validPartition(nums, flag, 0);
        return flag[nums.length-1];
    }

    private void validPartition(int[] nums, boolean[] flag, int i0) {
        if (i0 >= nums.length) {
            return;
        }
        int i2 = i0+1;
        int i3 = i0+2;
        if (i2 < nums.length && !flag[i2]) {
            flag[i2] = nums[i0] == nums[i0+1];
            if (flag[i2]) {
                validPartition(nums, flag, i2+1);
            }
        }
        if (i3 < nums.length && !flag[i3]) {
            flag[i3] = ((nums[i0] == nums[i0+1] && nums[i0] == nums[i0+2]) || (nums[i0]+1 == nums[i0+1] && nums[i0]+2 == nums[i0+2]));
            if (flag[i3]) {
                validPartition(nums, flag, i3+1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.validPartition(new int[]{4,4,4,5,6}));
        // false
        System.out.println(s.validPartition(new int[]{1,1,1,2}));
    }
}