import java.util.*;
/*
 * 1658-minimum-operations-to-reduce-x-to-zero.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/24
 */
public class Solution {
    public int minOperations(int[] nums, int x) {
        if (nums[0] > x && nums[nums.length - 1] > x) {
            return -1;
        }
        Map<Integer, Integer> leftCumMap = new HashMap<>();
        int sum = 0;
        int i = 0;
        leftCumMap.put(sum, i);
        while (i < nums.length) {
            sum += nums[i];
            if (sum > x) {
                break;
            }
            leftCumMap.put(sum, i + 1);
            i++;
        }
        if (sum < x) {
            return -1;
        }
        // reverse
        int other;
        int min = leftCumMap.getOrDefault(x, Integer.MAX_VALUE);
        sum = 0;
        i = nums.length - 1;
        while (i >= 0 && sum < x) {
            sum += nums[i];
            other = x - sum;
            if (leftCumMap.containsKey(other)) {
                min = Math.min(min, leftCumMap.get(other) + nums.length - i);
            }
            i--;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minOperations(new int[]{1,1,4,2,3}, 5));
        // -1
        System.out.println(s.minOperations(new int[]{5,6,7,8,9}, 4));
        // 5
        System.out.println(s.minOperations(new int[]{3,2,20,1,1,3}, 10));
    }
}