import java.util.*;

/*
 * 0454-4sum-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/04
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                count += map.getOrDefault(-sum, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.fourSumCount(
            new int[] {1,2},
            new int[] {-2,-1},
            new int[] {-1,2},
            new int[] {0,2}
        ));
    }
}