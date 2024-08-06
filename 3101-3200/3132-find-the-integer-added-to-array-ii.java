import java.util.*;

/**
 * 3132-find-the-integer-added-to-array-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/06
 */
public class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        for (int n : nums1) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        for (int n : nums2) {
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                int a = nums1[i];
                int ac = map1.get(a);
                if (ac == 1) {
                    map1.remove(a);
                } else {
                    map1.put(a, ac-1);
                }
                int b = nums1[j];
                int bc = map1.get(b);
                if (bc == 1) {
                    map1.remove(b);
                } else {
                    map1.put(b, bc-1);
                }
                if (ok(map1, map2)) {
                    min = Math.min(min, map2.firstKey() - map1.firstKey());
                }
                map1.put(a, map1.getOrDefault(a, 0) + 1);
                map1.put(b, map1.getOrDefault(b, 0) + 1);
            }
        }
        return min;
    }

    private boolean ok(TreeMap<Integer, Integer> m1, TreeMap<Integer, Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }
        int diff = m2.firstKey() - m1.firstKey();
        for (Map.Entry<Integer, Integer> e : m1.entrySet()) {
            Integer v2 = m2.get(e.getKey() + diff);
            if (v2 == null) {
                return false;
            }
            if (!v2.equals(e.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // -2
        System.out.println(s.minimumAddedInteger(new int[] {4,20,16,12,8}, new int[] {14,18,10}));
        // 2
        System.out.println(s.minimumAddedInteger(new int[] {3,5,5,3}, new int[] {7,7}));
    }
}
