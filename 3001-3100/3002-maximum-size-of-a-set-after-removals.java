import java.util.*;

/**
 * 3002-maximum-size-of-a-set-after-removals.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/10
 */
public class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>(nums1.length/2);
        Set<Integer> s2 = new HashSet<>(nums2.length/2);
        for (int n : nums1) {
            s1.add(n);
        }
        for (int n : nums2) {
            s2.add(n);
        }
        Set<Integer> s3 = new HashSet<>((s1.size() + s2.size()) / 2);

        Iterator<Integer> it = s1.iterator();
        while (it.hasNext()) {
            Integer n = it.next();
            if (s2.contains(n)) {
                it.remove();
                s2.remove(n);
                s3.add(n);
            }
        }
        if (s1.size() <= nums1.length/2 && s2.size() <= nums2.length/2) {
            return Math.min(nums1.length, s1.size()+s2.size()+s3.size());
        } else if (s1.size() > nums1.length/2 && s2.size() > nums2.length/2) {
            return nums1.length;
        } else if (s1.size() > nums1.length/2) {
            return Math.min(nums1.length, nums1.length/2+s2.size()+s3.size());
        } else { // s2.size() > nums2.length/2
            return Math.min(nums1.length, nums2.length/2+s1.size()+s3.size());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maximumSetSize(new int[]{1,2,1,2}, new int[]{1,1,1,1}));
        // 5
        System.out.println(s.maximumSetSize(new int[]{1,2,3,4,5,6}, new int[]{2,3,2,3,2,3}));
        // 6
        System.out.println(s.maximumSetSize(new int[]{1,1,2,2,3,3}, new int[]{4,4,5,5,6,6}));
    }
}
