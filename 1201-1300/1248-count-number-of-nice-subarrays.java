import java.util.*;
/**
 * 1248-count-number-of-nice-subarrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/22
 */
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                list.add(i - j - 1);
                j = i;
            }
        }
        list.add(nums.length - j - 1);
        System.out.println(list);
        int res = 0;
        j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i - j == k) {
                res += (list.get(i) + 1) * (list.get(j) + 1);
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.numberOfSubarrays(new int[] {1,1,2,1,1}, 3));
        // 0
        System.out.println(s.numberOfSubarrays(new int[] {2,4,6}, 1));
        // 16
        System.out.println(s.numberOfSubarrays(new int[] {2,2,2,1,2,2,1,2,2,2}, 2));
    }
}