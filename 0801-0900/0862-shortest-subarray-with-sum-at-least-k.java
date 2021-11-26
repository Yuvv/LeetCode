import java.util.LinkedList;

/*
 * 0862-shortest-subarray-with-sum-at-least-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/25
 */
public class Solution {
    public int shortestSubarray_tle(int[] nums, int k) {
        int minLen = nums.length + 1;

        int sum = 0, minusSum = 0;
        int i = 0;
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            if (nums[j] < 0) {
                minusSum += nums[j];
            }
            while (sum >= k) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                if (nums[i] < 0) {
                    minusSum -= nums[i];
                }
                i++;
            }
            if (sum - minusSum >= k) {
                minLen = Math.min(minLen, innerShortestSubarray(nums, i, j, k, sum));
            }
            if (minLen == 1) {
                // fast return
                return minLen;
            }
        }

        if (minLen > nums.length) {
            return -1;
        }

        return minLen;
    }

    public int innerShortestSubarray(int[] nums, int i, int j, int k, int sum) {
        int minLen = nums.length + 1;
        while (i < j) {
            sum -= nums[i];
            if (sum >= k) {
                minLen = Math.min(minLen, j - i);
            }
            i++;
        }
        return minLen;
    }

    public int shortestSubarray(int[] nums, int k) {
        int minLen = nums.length + 1;

        long[] cumsum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            cumsum[i + 1] = cumsum[i] + nums[i];
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cumsum.length; i++) {
            while (!queue.isEmpty() && cumsum[i] <= cumsum[queue.getLast()]) {
                queue.removeLast();
            }
            while (!queue.isEmpty() && cumsum[i] >= cumsum[queue.getFirst()] + k) {
                minLen = Math.min(minLen, i - queue.removeFirst());
            }
            queue.addLast(i);
        }

        if (minLen > nums.length) {
            return -1;
        }
        return minLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.shortestSubarray(new int[] {1}, 1));
        // -1
        System.out.println(s.shortestSubarray(new int[] {1,2}, 4));
        // 3
        System.out.println(s.shortestSubarray(new int[] {2,-1,2}, 3));
        // 2
        System.out.println(s.shortestSubarray(new int[] {1,2,3,4,2,2,3,1,2,3,4,5,6,4,3,2,1,3,4,5,6,4,3,2,4,5,6,4}, 10));
        // 2
        System.out.println(s.shortestSubarray(new int[] {1,2,3,4,-2,2,-3,1,2,-3,4,-5,6,4,3,-2,1,3,4,-5,6,4,-3,2,-4,5,-6,4}, 9));
    }
}