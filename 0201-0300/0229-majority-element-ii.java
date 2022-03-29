import java.util.*;

/*
 * 0229-majority-element-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/29
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resList = new ArrayList<>(2);
        Arrays.sort(nums);
        int n3 = nums.length / 3;
        int i = 0, j = 1;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j - i > n3) {
                resList.add(nums[i]);
            }
            i = j;
        }
        if (j - i > n3) {
            resList.add(nums[i]);
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3]
        System.out.println(s.majorityElement(new int[] {3,2,3}));
        // [1]
        System.out.println(s.majorityElement(new int[] {1}));
        // [1,2]
        System.out.println(s.majorityElement(new int[] {1,2}));
    }
}