/**
 * 3005-count-elements-with-maximum-frequency.java
 *
 * @date 2024/3/9
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    // 1 <= nums[i] <= 100
    public int maxFrequencyElements(int[] nums) {
        int[] cntarr = new int[101];
        int maxf = 1;
        for (int n : nums) {
            cntarr[n]++;
            if (cntarr[n] > maxf) {
                maxf = cntarr[n];
            }
        }
        int maxv = 0;
        for (int n : cntarr) {
            if (n == maxf) {
                maxv += maxf;
            }
        }
        return maxv;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maxFrequencyElements(new int[]{1,2,2,3,1,4}));
        // 5
        System.out.println(s.maxFrequencyElements(new int[]{1,2,3,4,5}));
    }
}
