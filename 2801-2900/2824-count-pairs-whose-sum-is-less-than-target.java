import java.util.*;
/*
 * 2824-count-pairs-whose-sum-is-less-than-target.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/08/27
 */
public class Solution {
    public int countPairs(List<Integer> nums, int target) {
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), k -> new HashSet<>()).add(i);
        }
        int cnt = 0;
        Integer firstKey = map.firstKey();
        for (int i = 0; i < nums.size(); i++) {
            Integer n = nums.get(i);
            Integer toKey = target - n;
            if (toKey <= firstKey) {
                continue;
            }
            for (Set<Integer> set : map.subMap(firstKey, true, toKey, false).values()) {
                for (Integer e : set) {
                    if (e > i) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.countPairs(
            Arrays.asList(-1,1,2,3,1), 2
        ));
        // 10
        System.out.println(s.countPairs(
            Arrays.asList(-6,2,5,-2,-7,-1,3), -2
        ));
    }
}