import java.util.*;

/*
 * 1695-maximum-erasure-value.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 1970/01/01
 */
public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            int e = nums[j];
            if (set.contains(e)) {
                while (i < j && set.contains(e)) {
                    set.remove(nums[i]);
                    sum -= nums[i];
                    i++;
                }
            }
            sum += e;
            set.add(e);

            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 17
        System.out.println(s.maximumUniqueSubarray(new int[] {4,2,4,5,6}));
        // 1
        System.out.println(s.maximumUniqueSubarray(new int[] {1}));
        // 10001
        System.out.println(s.maximumUniqueSubarray(new int[] {10000,1,10000,1,1,1,1,1,1}));
    }
}
