import java.util.*;

/*
 * 2289-steps-to-make-array-non-decreasing.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/21
 */
public class Solution {
    public int totalSteps_tle(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        int total = 0;
        while (!list.isEmpty()) {
            Iterator<Integer> it = list.iterator();
            Integer val = it.next();
            int moved = 0;
            while (it.hasNext()) {
                Integer next = it.next();
                if (next < val) {
                    it.remove();
                    moved++;
                }
                val = next;
            }
            if (moved > 0) {
                total++;
            } else {
                break;
            }
        }
        return total;
    }

    // ref: https://leetcode.com/problems/steps-to-make-array-non-decreasing/discuss/2115834/Monostack-with-Counter
    public int totalSteps(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] dp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int cnt = 0;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                cnt = Math.max(cnt + 1, dp[stack.peek()]);
                stack.pop();
            }
            stack.push(i);
            dp[i] = cnt;
        }
        int total = 0;
        for (int val : dp) {
            total = Math.max(total, val);
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.totalSteps(new int[] {5,3,4,4,7,3,6,11,8,5,11}));
    }
}