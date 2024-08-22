/**
 * 3095-shortest-subarray-with-or-at-least-k-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/22
 */
public class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[6]; // 1 <= nums[i] <= 50
        int i = 0;
        int minLen = nums.length + 1;
        int j = 0;
        while (j < nums.length) {
            int n = merge(bits, nums[j]);
            while (i <= j && n >= k) {
                minLen = Math.min(j - i + 1, minLen);
                n = remove(bits, nums[i]);
                i++;
            }
            j++;
        }
        if (minLen > nums.length) {
            return -1;
        }
        return minLen;
    }

    private int merge(int[] bits, int x) {
        int i = 0;
        while (x > 0) {
            if ((x&1) > 0) {
                bits[i]++;
            }
            i++;
            x >>= 1;
        }
        int n = 0;
        for (i = 0; i < bits.length; i++) {
            if (bits[i] > 0) {
                n |= (1 << i);
            }
        }
        return n;
    }

    private int remove(int[] bits, int x) {
        int i = 0;
        while (x > 0) {
            if ( (x&1) > 0 ) {
                bits[i]--;
            }
            i++;
            x >>= 1;
        }
        int n = 0;
        for (i = 0; i < bits.length; i++) {
            if (bits[i] > 0) {
                n |= (1 << i);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minimumSubarrayLength(new int[] {1,2,3}, 2));
        // 3
        System.out.println(s.minimumSubarrayLength(new int[] {2,1,8}, 10));
        // 1
        System.out.println(s.minimumSubarrayLength(new int[] {1,2}, 0));
    }
}
