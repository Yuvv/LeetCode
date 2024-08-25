import java.util.*;
/**
 * 2780-minimum-index-of-a-valid-split.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/25
 */
public class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (Integer n : nums) {
            cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);
        }
        Map<Integer, Integer> leftCntMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer n = nums.get(i);
            leftCntMap.put(n, leftCntMap.getOrDefault(n, 0) + 1);
            if (leftCntMap.get(n)*2 > (i+1) && (cntMap.get(n)-leftCntMap.get(n))*2 > (nums.size()-i-1)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minimumIndex(Arrays.asList(1,2,2,2)));
        // 4
        System.out.println(s.minimumIndex(Arrays.asList(2,1,3,1,1,1,7,1,2,1)));
        // -1
        System.out.println(s.minimumIndex(Arrays.asList(3,3,3,3,7,2,2)));
    }
}
