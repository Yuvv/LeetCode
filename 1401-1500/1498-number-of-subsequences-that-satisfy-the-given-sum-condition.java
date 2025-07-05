import java.util.*;

/**
 * 1498-number-of-subsequences-that-satisfy-the-given-sum-condition.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/05
 */
public class Solution {
    static final int MOD = 1000000007;
    private int bSearch(int[] nums, int iv, int i, int j, int target) {
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] + iv > target) {
                j = mid - 1; // mid is too large
            } else {
                i = mid;
            }
            if (j - i == 1) {
                if (nums[j] + iv > target) {
                    j--;
                } else {
                    break;
                }
            }
        }
        return j;
    }

    public int numSubseq(int[] nums, int target) {
        int[] pow2n = new int[nums.length];
        pow2n[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow2n[i] = (pow2n[i - 1] * 2) % MOD;
        }
        long sum = 0L;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < nums.length) {
            if (nums[i] * 2 > target) {
                // fast fail
                break;
            }
            // move to last valid j
            if (nums[j] + nums[i] > target) {
                j = bSearch(nums, nums[i], i, j - 1, target);
            } else {
                j = bSearch(nums, nums[i], j, nums.length - 1, target);
            }
            if (j >= i) {
                sum += pow2n[j - i];
                sum %= MOD;
            }
            i++;
        }

        return (int) (sum % MOD);
    }

    public int numSubseq_faster(int[] nums, int target) {
        int mod = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int left = 0 , right = n - 1 , result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.numSubseq(new int[]{3, 5, 6, 7}, 9));
        // 6
        System.out.println(s.numSubseq(new int[]{3, 3, 6, 8}, 10));
        // 61
        System.out.println(s.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }
}