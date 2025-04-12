import java.util.*;
/**
 * 3396-minimum-number-of-operations-to-make-elements-in-array-distinct.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/12
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen.contains(nums[i])) {
                return (i + 3) / 3;
            } else {
                seen.add(nums[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minimumOperations(new int[] {1,2,3,4,2,3,3,5,7}));
        // 2
        System.out.println(s.minimumOperations(new int[] {4,5,6,4,4}));
        // 0
        System.out.println(s.minimumOperations(new int[] {6,7,8,9}));
    }
}
