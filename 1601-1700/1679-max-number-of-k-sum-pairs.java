import java.util.*;

/*
 * 1679-max-number-of-k-sum-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/04
 */
public class Solution {
    public int maxOperations(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int target = k - num;
            if (map.containsKey(target)) {
                int val = map.get(target);
                if (val == 1) {
                    map.remove(target);
                } else {
                    map.put(target, val - 1);
                }
                sum++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.maxOperations(new int[] {1,2,3,4}, 5));
        // 1
        System.out.println(s.maxOperations(new int[] {3,1,3,4,3}, 6));
    }
}