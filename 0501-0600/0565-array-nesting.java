import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/*
 * 0565-array-nesting.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/01
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        Map<Integer, Integer> valIdxMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            valIdxMap.put(nums[i], i);
        }
        int maxLen = 0;
        Set<Integer> chainSet = new HashSet<>();
        Set<Integer> curChainSet;
        for (int num : nums) {
            if (chainSet.contains(num)) {
                continue;
            }
            int originNum = num;
            curChainSet = new HashSet<>();
            curChainSet.add(num);
            // suffix
            while (!curChainSet.contains(nums[num])) {
                num = nums[num];
                curChainSet.add(num);
            }
            // prefix
            num = originNum;
            for (int i = valIdxMap.get(num); !curChainSet.contains(nums[i]); num = nums[i]) {
                curChainSet.add(nums[i]);
            }

            chainSet.addAll(curChainSet);
            maxLen = Math.max(maxLen, curChainSet.size());
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.arrayNesting(new int[] {5, 4, 0, 3, 1, 6, 2}));
        // 1
        System.out.println(s.arrayNesting(new int[] {0, 1, 2}));
    }
}