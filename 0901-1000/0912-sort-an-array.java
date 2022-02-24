import java.util.*;

/*
 * 0912-sort-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/02/24
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,5]
        System.out.println(new int[] {5,2,3,1});
    }
}