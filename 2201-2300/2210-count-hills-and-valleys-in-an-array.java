/**
 * 2210-count-hills-and-valleys-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/05
 */
public class Solution {
    public int countHillValley(int[] nums) {
        int i = 0;
        int j = i+1;
        while (j < nums.length && nums[j] == nums[i]) {
            j++;
        }
        if (j >= nums.length) {
            return 0; // fast fail
        }
        int k = j+1;
        while (k < nums.length && nums[k] == nums[j]) {
            k++;
        }
        if (k >= nums.length) {
            return 0; // fast fail
        }
        int cnt = 0;
        while (k < nums.length) {
            if (nums[j] > nums[i] && nums[j] > nums[k]) {
                cnt++;
            } else if (nums[j] < nums[i] && nums[j] < nums[k]) {
                cnt++;
            }
            i = j;
            j = k;
            k = k+1;
            while (k < nums.length && nums[k] == nums[j]) {
                k++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.countHillValley(new int[] {2,4,1,1,6,5}));
        // 0
        System.out.println(s.countHillValley(new int[] {6,6,5,5,4,1}));
    }
}