import java.util.Map;
import java.util.HashMap;

/*
 * 1207-unique-number-of-occurrences.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/19
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap.values().stream().distinct().count() == countMap.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        // false
        System.out.println(s.uniqueOccurrences(new int[]{1,2}));
        // true
        System.out.println(s.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}