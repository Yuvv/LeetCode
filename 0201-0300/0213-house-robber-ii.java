/*
 * 0213-house-robber-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/05
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }
    }

    public int rob(int[] nums, int i, int j) {
        int last, cur, tmp;

        last = nums[i];
        cur = Math.max(nums[i], nums[i + 1]);
        for (int k = i + 2; k <= j; k++) {
            tmp = Math.max(cur, last + nums[k]);
            last = cur;
            cur = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.rob(new int[] {2,3,2}));
        // 4
        System.out.println(s.rob(new int[] {1,2,3,1}));
        // 3
        System.out.println(s.rob(new int[] {1,2,3}));
    }
}