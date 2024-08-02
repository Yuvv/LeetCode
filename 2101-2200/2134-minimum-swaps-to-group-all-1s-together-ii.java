import java.util.*;

/**
 * 2134-minimum-swaps-to-group-all-1s-together-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/02
 */
public class Solution {
    public int minSwaps(int[] nums) {
        int SUM = Arrays.stream(nums).sum(); // final 1s window size
        // now, our mission is to find out the window of size SUM with MAXIMUM 1s.
        int cnt = 0;  // current 1s count in final window
        for (int i = 0; i < SUM; i++) {
            cnt += nums[i];
        }
        int max = cnt;
        for (int i = SUM; i < nums.length+SUM; i++) {
            cnt += nums[i % nums.length] - nums[(i - SUM + nums.length) % nums.length];
            max = Math.max(max, cnt);
        }
        return SUM - max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minSwaps(new int[] {0,1,0,1,1,0,0}));
        // 2
        System.out.println(s.minSwaps(new int[] {0,1,1,1,0,0,1,1,0}));
        // 0
        System.out.println(s.minSwaps(new int[] {1,1,0,0,1}));
    }
}
