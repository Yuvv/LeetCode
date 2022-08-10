import java.util.*;

/*
 * 2295-replace-elements-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/10
 */
public class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] op : operations) {
            int idx = map.remove(op[0]);
            nums[idx] = op[1];
            map.put(op[1], idx);
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,2,7,1]
        System.out.println(Arrays.toString(s.arrayChange(
            new int[] {1,2,4,6},
            new  int[][] {{1,3}, {4,7}, {6,1}}
        )));
    }
}