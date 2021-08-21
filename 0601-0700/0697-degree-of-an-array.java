import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/*
 * 0697-degree-of-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/21
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> countRangeMap = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (countRangeMap.containsKey(num)) {
                List<Integer> list = countRangeMap.get(num);
                list.set(0, list.get(0) + 1);
                list.set(2, i);
                maxCount = Math.max(list.get(0), maxCount);
            } else {
                countRangeMap.put(num, new ArrayList<>(Arrays.asList(1, i, i)));
            }
        }
        // get min length
        int minLength = nums.length;
        for (List<Integer> list : countRangeMap.values()) {
            if (list.get(0) < maxCount) {
                continue;
            }
            minLength = Math.min(minLength, list.get(2) - list.get(1) + 1);
        }

        return minLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findShortestSubArray(new int[] {1,2,2,3,1}));
        // 6
        System.out.println(s.findShortestSubArray(new int[] {1,2,2,3,1,4,2}));
        // 7
        System.out.println(s.findShortestSubArray(new int[] {1,2,1,2,3,1,1,4,2,2}));
    }
}