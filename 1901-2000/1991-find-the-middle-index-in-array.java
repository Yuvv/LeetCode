/*
 * 1991-find-the-middle-index-in-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/07
 */
public class Solution {
    public int findMiddleIndex(int[] nums) {
        // right cum sum
        int[] cumsum = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            cumsum[i] = cumsum[i + 1] + nums[i];
        }
        int leftSum = 0;
        int idx = 0;
        while (idx < nums.length) {
            if (leftSum == cumsum[idx + 1]) {
                return idx;
            }
            leftSum += nums[idx];
            idx++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.findMiddleIndex(new int[]{2,3,-1,8,4}));
        // 2
        System.out.println(s.findMiddleIndex(new int[]{1,-1,4}));
        // -1
        System.out.println(s.findMiddleIndex(new int[]{2,5}));
    }
}