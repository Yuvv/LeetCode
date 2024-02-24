import java.util.Arrays;

/**
 * 2966-divide-array-into-arrays-with-max-difference.java
 *
 * @date 2024/2/24
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] res = new int[nums.length / 3][];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][];
            }
            res[i / 3] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,1,3],[3,4,5],[7,8,9]]
        System.out.println(Arrays.toString(s.divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2)));
        // []
        System.out.println(Arrays.toString(s.divideArray(new int[]{1,3,3,2,7,3}, 3)));
    }
}
