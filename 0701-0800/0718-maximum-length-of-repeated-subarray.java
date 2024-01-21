import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0718-maximum-length-of-repeated-subarray.java
 *
 * @date 2024/1/21
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {

    public int findLength(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            idxMap.computeIfAbsent(nums2[i], k->new ArrayList<>()).add(i);
        }

        int max = 0;
        for (int i = 0; i +max < nums1.length; i++) {
            if (!idxMap.containsKey(nums1[i])) {
                continue;
            }
            for (Integer j : idxMap.get(nums1[i])) {
                int k = 1;
                while (i+k < nums1.length && j + k < nums2.length && nums1[i+k] == nums2[j+k]) {
                    k++;
                }
                max = Math.max(max, k);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.findLength(
                    new int[]{1,2,3,2,1},
                    new int[]{3,2,1,4,7}));
        // 5
        System.out.println(s.findLength(
                    new int[]{0,0,0,0,0},
                    new int[]{0,0,0,0,0}));
    }
}
