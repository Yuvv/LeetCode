import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

/*
 * 1394-find-lucky-integer-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/15
 */
public class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer maxCount = 0;
        Integer maxValue = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue()) && entry.getValue() > maxCount) {
                maxValue = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return Optional.ofNullable(maxValue).orElse(-1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findLucky(new int[] {2,2,3,4}));
        // 3
        System.out.println(s.findLucky(new int[] {1,2,2,3,3,3}));
    }
}