/**
 * 0719-find-k-th-smallest-pair-distance.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/14
 */
public class Solution {
        public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int c = check(nums, k, mi);
            if (c > 0) {
                hi = mi - 1;
            } else if (c < 0) {
                lo = mi + 1;
            } else {
                // lo = mi + 1;
                return mi;
            }
        }
        return lo;
    }

    private int check(int[] nums, int k, int mi) {
        int ltcnt = 0;
        int eqcnt = 0;
        int i = 0;
        int j = 1;
        int j1;
        while (i < nums.length) {
            while (j < nums.length && nums[j] - nums[i] < mi) {
                j++;
            }
            ltcnt += j - i - 1;
            j1 = j;
            while (j1 < nums.length && nums[j1] - nums[i] == mi) {
                j1++;
            }
            eqcnt += j1 - j;
            //
            i++;
            if (ltcnt >= k) {
                return 1; // fast return
            }
        }
        if (ltcnt >= k) {
            return 1;
        } else if (ltcnt + eqcnt < k) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.smallestDistancePair(new int[] {1,3,1}, 1));
        // 0
        System.out.println(s.smallestDistancePair(new int[] {1,1,1}, 2));
        // 5
        System.out.println(s.smallestDistancePair(new int[] {1,6,1}, 3));
    }
}
