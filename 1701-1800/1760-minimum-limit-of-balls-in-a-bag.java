import java.util.Arrays;

/*
 * 1760-minimum-limit-of-balls-in-a-bag.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/20
 */
public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        int lo = Math.max(1, sum / (nums.length + maxOperations));
        int hi = Math.max(1, max);
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (isPossible(nums, maxOperations, mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return hi;
    }

    public boolean isPossible(int[] nums, int maxop, int val) {
        int cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= val) {
                break;
            }
            cnt += nums[i] / val;
            if (nums[i] % val == 0) {
                cnt--;
            }
            if (cnt > maxop) {
                return false;
            }
        }
        return cnt <= maxop;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minimumSize(new int[] {9}, 2));
        // 2
        System.out.println(s.minimumSize(new int[] {2,4,8,2}, 4));
        // 7
        System.out.println(s.minimumSize(new int[] {7,17}, 2));
    }
}