import java.util.*;

/*
 * 1365-how-many-numbers-are-smaller-than-the-current-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/08
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], i);
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [4,0,1,1,3]
        System.out.println(Arrays.toString(
            s.smallerNumbersThanCurrent(new int[] {8,1,2,2,3})
        ));
    }
}