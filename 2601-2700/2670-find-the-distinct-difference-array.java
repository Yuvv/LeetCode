import java.util.*;

/*
 * 2670-find-the-distinct-difference-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/05/21
 */
public class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            prefixSum[i] = set.size();
        }
        set.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
            suffixSum[i] = set.size();
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            res[i] = prefixSum[i] - suffixSum[i+1];
        }
        res[nums.length - 1] = prefixSum[nums.length - 1];
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [-3,-1,1,3,5]
        System.out.println(Arrays.toString(s.distinctDifferenceArray(new int[] {1,2,3,4,5})));
        // [-2,-1,0,2,3]
        System.out.println(Arrays.toString(s.distinctDifferenceArray(new int[] {3,2,3,4,2})));
    }
}