import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;

/*
 * 0368-largest-divisible-subset.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/15
 */
public class Solution {
    private Map<Integer, List<Integer>> cacheMap;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        cacheMap = new HashMap<>();

        Arrays.sort(nums);
        List<Integer> maxSs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> res = getLargestSubset(nums, i);
            if (maxSs.size() < res.size()) {
                maxSs = res;
            }
        }
        return maxSs;
    }

    public List<Integer> getLargestSubset(int[] nums, int fromIdx) {
        if (fromIdx >= nums.length) {
            return Collections.emptyList();
        }
        if (cacheMap.containsKey(fromIdx)) {
            return cacheMap.get(fromIdx);
        }
        List<Integer> maxSubSet = Collections.emptyList();
        for (int i = fromIdx + 1; i < nums.length; i++) {
            if (nums[i] % nums[fromIdx] == 0) {
                List<Integer> nextList;
                if (cacheMap.containsKey(i)) {
                    nextList = cacheMap.get(i);
                } else {
                    nextList = getLargestSubset(nums, i);
                    cacheMap.put(i, nextList);
                }
                if (nextList.size() > maxSubSet.size()) {
                    maxSubSet = nextList;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[fromIdx]);
        res.addAll(maxSubSet);
        cacheMap.put(fromIdx, res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2]
        System.out.println(s.largestDivisibleSubset(new int[] {1, 2, 3}));
        // [1,2,4,8]
        System.out.println(s.largestDivisibleSubset(new int[] {1, 2, 4, 8}));
        // [9,18,90,180,360,720]
        System.out.println(s.largestDivisibleSubset(new int[] {5,9,18,54,108,540,90,180,360,720}));
    }
}