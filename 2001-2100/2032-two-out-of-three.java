import java.util.*;

/*
 * 2032-two-out-of-three.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/14
 */
public class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> nums1Set = new HashSet<>(nums1.length);
        Set<Integer> nums2Set = new HashSet<>(nums2.length);
        for (int num : nums1) {
            nums1Set.add(num);
        }
        for (int num : nums2) {
            nums2Set.add(num);
        }
        for (int num : nums3) {
            if (nums1Set.contains(num) || nums2Set.contains(num)) {
                result.add(num);
            }
        }

        nums1Set.retainAll(nums2Set);
        result.addAll(nums1Set);

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,2]
        System.out.println(s.twoOutOfThree(new int[]{1,1,3,2}, new int[]{2,3}, new int[]{3}));
        // [2,3,1]
        System.out.println(s.twoOutOfThree(new int[]{3,1}, new int[]{2,3}, new int[]{1,2}));
    }
}