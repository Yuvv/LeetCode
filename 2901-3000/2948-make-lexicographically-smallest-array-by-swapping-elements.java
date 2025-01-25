import java.util.*;

/**
 * 2948-make-lexicographically-smallest-array-by-swapping-elements.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/01/25
 */
public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        Map<Integer, PriorityQueue<Integer>> unionMap = new HashMap<>();
        Map<Integer, Integer> groupMap = new HashMap<>();
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);
        int g = 0;
        groupMap.put(copyNums[0], g);
        unionMap.computeIfAbsent(g, k -> new PriorityQueue<>()).add(copyNums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (copyNums[i] - copyNums[i - 1] <= limit) {
                groupMap.put(copyNums[i], g);
                unionMap.get(g).add(copyNums[i]);
            } else {
                g++;
                groupMap.put(copyNums[i], g);
                unionMap.computeIfAbsent(g, k -> new PriorityQueue<>()).add(copyNums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = unionMap.get(groupMap.get(nums[i])).poll();
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,3,5,8,9]
        System.out.println(s.lexicographicallySmallestArray(new int[]{1,5,4,9,8}, 2));
        // [1,6,7,18,1,2]
        System.out.println(s.lexicographicallySmallestArray(new int[]{1,7,6,18,2,1}, 3));
    }
}
