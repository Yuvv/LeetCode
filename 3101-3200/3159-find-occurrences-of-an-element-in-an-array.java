import java.util.*;

/**
 * 3159-find-occurrences-of-an-element-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/07
 */
public class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != x) {
                continue;
            }
            map.put(map.size()+1, i);
        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = map.getOrDefault(queries[i], -1);
        }
        return queries;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,-1,2,-1]
        System.out.println(Arrays.toString(s.occurrencesOfElement(
            new int[] {1,3,1,7}, new int[] {1,3,2,4}, 1
        )));
        // [-1]
        System.out.println(Arrays.toString(s.occurrencesOfElement(
            new int[] {1,2,3}, new int[] {10}, 5
        )));
    }
}
