import java.util.*;
/**
 * 0974-subarray-sums-divisible-by-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/16
 */
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(((nums[0] % k) + k) % k, 1);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
            int mod = ((nums[i] % k) + k ) % k;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        map.put(0, map.getOrDefault(0, 0) + 1);
        int cnt = 0;
        for (Map.Entry<Integer, Integer> se : map.entrySet()) {
            cnt += (se.getValue() - 1) * se.getValue() / 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
        // 0
        System.out.println(s.subarraysDivByK(new int[]{5}, 9));
    }
}