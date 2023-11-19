import java.util.Arrays;

/**
 * 1887-reduction-operations-to-make-the-array-elements-equal
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/19
 */
public class Solution {
    public int reductionOperations(int[] nums) {
        int total = 0;
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (i >= 0) {
            int val = nums[i];
            i--;
            while (i >= 0 && val == nums[i]) {
                i--;
            }
            if (i >= 0) {
                total += nums.length - 1 - i;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.reductionOperations(new int[] { 5, 1, 3 }));
        // 0
        System.out.println(s.reductionOperations(new int[] { 1, 1, 1 }));
        // 4
        System.out.println(s.reductionOperations(new int[] { 1, 1, 2, 2, 3 }));
    }
}
