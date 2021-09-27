import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*
 * 2006-count-number-of-pairs-with-absolute-difference-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/27
 */
public class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, List<Integer>> valIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valIdxMap.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }
        int res = 0;
        int target;
        for (int i = 0; i < nums.length; i++) {
            // left-lt
            // right-gt
            target = k + nums[i];
            if (valIdxMap.containsKey(target)) {
                List<Integer> idxList = valIdxMap.get(target);
                if (idxList.indexOf(i) >= 0) {
                    res += idxList.size() - 1;
                } else {
                    res += idxList.size();
                }
            }
            // left-gt
            // right-lt
            target = nums[i] - k;
            if (valIdxMap.containsKey(target)) {
                List<Integer> idxList = valIdxMap.get(target);
                if (idxList.indexOf(i) >= 0) {
                    res += idxList.size() - 1;
                } else {
                    res += idxList.size();
                }
            }
        }
        return res / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countKDifference(new int[] {1,2,2,1}, 1));
        // 0
        System.out.println(s.countKDifference(new int[] {1,3}, 3));
        // 3
        System.out.println(s.countKDifference(new int[] {3,2,1,5,4}, 2));
        // 4
        System.out.println(s.countKDifference(new int[] {1,2,2,1,3,3,4,5,6}, 4));
    }
}