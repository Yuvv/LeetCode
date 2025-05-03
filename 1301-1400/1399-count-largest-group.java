import java.util.*;
/**
 * 1399-count-largest-group.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/03
 */
public class Solution {
    // 1 <= n <= 10^4
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int x = i;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int max = 0;
        int mc = 0;
        for (int count : map.values()) {
            if (count == max) {
                mc++;
            } else if (count > max) {
                mc = 1;
                max = count;
            }
         }
        return mc;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countLargestGroup(13));
        // 2
        System.out.println(s.countLargestGroup(2));
    }
}
