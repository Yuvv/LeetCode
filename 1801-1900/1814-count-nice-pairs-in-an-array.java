import java.util.*;

/*
 * 1814-count-nice-pairs-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/03/26
 */
public class Solution {

    private int rev(int a) {
        int x = 0;
        while (a > 0) {
            x = x*10 + (a % 10);
            a /= 10;
        }
        return x;
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        for (int n : nums) {
            int x = n - rev(n);
            map.put(x, map.getOrDefault(x, 0L) + 1);
        }
        long count = 0L;
        for (Long cnt : map.values()) {
            if (cnt > 1) {
                count += cnt * (cnt - 1) / 2;
            }
        }
        return (int) (count % 1000000007);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countNicePairs(new int[] {42,11,1,97}));
        // 4
        System.out.println(s.countNicePairs(new int[] {13,10,35,24,76}));
    }
}