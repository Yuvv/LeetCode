/*
 * 2293-min-max-game.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/19
 */
public class Solution {
    public int minMaxGame(int[] nums) {
        int end = nums.length;
        while (end > 1) {
            int pos = 0;
            for (int i = 0; i < end; i += 2) {
                if (pos % 2 == 0) {
                    nums[pos] = Math.min(nums[i], nums[i+1]);
                } else {
                    nums[pos] = Math.max(nums[i], nums[i+1]);
                }
                pos++;
            }
            end /= 2;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minMaxGame(new int[] {1,3,5,2,4,8,2,2}));
    }
}