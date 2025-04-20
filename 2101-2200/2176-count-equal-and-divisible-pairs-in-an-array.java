import java.util.*;
/**
 * 2176-count-equal-and-divisible-pairs-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/20
 */
public class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        int cnt = 0;
        for (List<Integer> list : map.values()) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if ((list.get(i) * list.get(j)) % k == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countPairs(new int[]{3,1,2,2,2,1,3}, 2));
        // 0
        System.out.println(s.countPairs(new int[]{1,2,3,4}, 1));
    }
}
