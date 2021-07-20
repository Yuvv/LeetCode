import java.util.Map;
import java.util.TreeMap;

/*
 * 0594-longest-harmonious-subsequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/20
 */
public class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        int maxLen = 0;
        Map.Entry<Integer, Integer> lastEntry = null;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (lastEntry != null && entry.getKey() - lastEntry.getKey() == 1) {
                Integer len = lastEntry.getValue() + entry.getValue();
                if (len > maxLen) {
                    maxLen = len;
                }
            }
            lastEntry = entry;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.findLHS(new int[]{1,3,2,2,5,2,3,7}));
        // 2
        System.out.println(s.findLHS(new int[]{1,2,3,4}));
        // 0
        System.out.println(s.findLHS(new int[]{1,1,1,1}));
    }
}