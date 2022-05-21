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
    /**
     * Union-Find  --  Accepted
     *
     * Time: O(N)
     * Space: O(N)
     */
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
            // prefix -- there is no need to fin prefix since "all the values of nums are unique",
            // so the chain is always a ring if it exists
            num = originNum;
            for (int i = valIdxMap.get(num); !curChainSet.contains(nums[i]); num = nums[i]) {
                curChainSet.add(nums[i]);
            }

            chainSet.addAll(curChainSet);
            maxLen = Math.max(maxLen, curChainSet.size());
        }

        return maxLen;
    }

    /**
     * Using visited array - Accepted
     * Time: O(N)
     * Space: O(N)  -- but more space efficient
     */
    public int arrayNesting_visited(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int count = 0;
                int num = nums[i];
                do {
                    visited[num] = true;
                    count++;
                    num = nums[num];
                } while (!visited[num]);
                max = Math.max(count, max);
            }
        }
        return max;
    }

    /**
     * without extra space - Accepted
     * Time: O(N)
     * Space: O(1)
     */
    public int arrayNesting_space_o1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {  // which means not visited
                int count = 0;
                int num = nums[i];
                do {
                    int tmp = num;
                    count++;
                    num = nums[num];
                    nums[tmp] = -1;
                } while (nums[num] >= 0);
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.arrayNesting(new int[] {5, 4, 0, 3, 1, 6, 2}));
        // 1
        System.out.println(s.arrayNesting(new int[] {0, 1, 2}));
    }
}