import java.util.*;
/**
 * 3375-minimum-operations-to-make-array-values-equal-to-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/12
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int min = nums[0];
        for (int n : nums) {
            if (n < min) {
                min = n;
            }
            set.add(n);
        }
        if (min < k) {
            return -1;
        } else if (min == k) {
            return set.size() - 1;
        } else {
            return set.size();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minOperations(new int[] {5,2,5,4,5}, 2));
        // -1
        System.out.println(s.minOperations(new int[] {2,1,2}, 2));
        // 4
        System.out.println(s.minOperations(new int[] {9,7,5,3}, 1));
    }
}
