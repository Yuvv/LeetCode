import java.util.*;

/*
 * 0659-split-array-into-consecutive-subsequences.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/19
 */
public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> needMap = new HashMap<>();
        for (int num : nums) {
            if (cntMap.getOrDefault(num, 0) == 0) {
                continue;
            }
            if (needMap.getOrDefault(num, 0) > 0) {
                needMap.put(num, needMap.getOrDefault(num, 0) - 1);
                cntMap.put(num, cntMap.getOrDefault(num, 0) - 1);

                needMap.put(num + 1, needMap.getOrDefault(num + 1, 0) + 1);
            } else if (cntMap.getOrDefault(num, 0) > 0
                    && cntMap.getOrDefault(num + 1, 0) > 0
                    && cntMap.getOrDefault(num + 2, 0) > 0) {
                cntMap.put(num, cntMap.getOrDefault(num, 0) - 1);
                cntMap.put(num + 1, cntMap.getOrDefault(num + 1, 0) - 1);
                cntMap.put(num + 2, cntMap.getOrDefault(num + 2, 0) - 1);

                needMap.put(num + 3, needMap.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isPossible(new int[] {1,2,3,3,4,5}));
        // true
        System.out.println(s.isPossible(new int[] {1,2,3,3,4,4,5,5}));
        // false
        System.out.println(s.isPossible(new int[] {1,2,3,4,4,5}));
    }
}