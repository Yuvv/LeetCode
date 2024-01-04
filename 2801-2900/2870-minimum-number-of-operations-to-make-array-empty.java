import java.util.HashMap;
import java.util.Map;

/**
 * 2870-minimum-number-of-operations-to-make-array-empty
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/1/4
 */
public class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return -1;
            }
            cnt += entry.getValue() / 3;
            if (entry.getValue() % 3 > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.minOperations(new int[] { 2, 3, 3, 2, 2, 4, 2, 3, 4 }));
        // -1
        System.out.println(s.minOperations(new int[] { 2, 1, 2, 2, 3, 3 }));
    }
}
