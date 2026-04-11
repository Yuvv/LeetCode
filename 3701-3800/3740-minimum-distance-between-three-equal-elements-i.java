import java.util.*;
/**
 * 3740-minimum-distance-between-three-equal-elements-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/04/11
 */
public class Solution {
    public int minimumDistance(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int minDis = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) {
                continue;
            }
            for (int i = 0; i < list.size() - 2; i++) {
                int dis = list.get(i + 2) - list.get(i);
                minDis = Math.min(minDis, dis*2);
            }
        }
        if (minDis == Integer.MAX_VALUE) {
            return -1;
        }
        return minDis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.minimumDistance(new int[]{1,2,1,1,3}));
        // 8
        System.out.println(s.minimumDistance(new int[]{1,1,2,3,2,1,2}));
        // -1
        System.out.println(s.minimumDistance(new int[]{1}));

    }
}