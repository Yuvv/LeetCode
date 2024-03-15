/**
 * 0930-binary-subarrays-with-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/14
 */
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        if (goal == 0) {
            while (i < nums.length) {
                while (i < nums.length && nums[i] != 0) {
                    i++;
                }
                if (i >= nums.length) {
                    break;
                }
                j = i+1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                count += (j - i) * (j - i + 1) / 2;
                i = j;
            }
            return count;
        }
        while (j < nums.length) {
            while (j < nums.length && sum < goal) {
                sum += nums[j];
                j++;
            }
            if (sum < goal) {
                break;
            }
            int originI = i;
            while (i < j && nums[i] == 0) {
                i++;
            }
            int originJ = j;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            count += (i - originI + 1) * (j - originJ + 1);
            if (i >= nums.length) {
                break;
            }
            // new start pos
            sum -= nums[i];
            i++;
            j = originJ;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        // 15
        System.out.println(s.numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}