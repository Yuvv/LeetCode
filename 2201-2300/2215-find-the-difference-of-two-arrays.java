import java.util.*;
import java.util.stream.*;

/*
 * 2215-find-the-difference-of-two-arrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/01
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> ns1 = new HashSet<>(nums1.length);
        for (int each : nums1) {
            ns1.add(each);
        }
        Set<Integer> ns2 = new HashSet<>(nums2.length);
        for (int each : nums2) {
            ns2.add(each);
        }
        List<Integer> res1 = ns1.stream()
                .filter(e -> !ns2.contains(e))
                .collect(Collectors.toList());
        List<Integer> res2 = ns2.stream()
                .filter(e -> !ns1.contains(e))
                .collect(Collectors.toList());
        return Arrays.asList(res1, res2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[1,3], [4,6]]
        System.out.println(s.findDifference(
            new int[] {1,2,3},
            new int[] {2,4,6}
        ));
        // [[3], []]
        System.out.println(s.findDifference(
            new int[] {1,2,3,3},
            new int[] {1,1,2,2}
        ));
    }
}