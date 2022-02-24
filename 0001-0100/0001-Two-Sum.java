import java.util.*;

public class Solution {
    // bad practice
    public int[] twoSum_1(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[] {-1, -1};
        }
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[] {-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                return new int[] {map.get(a), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1]
        System.out.println(Arrays.toString(s.twoSum(new int[] {2,7,11,15}, 9)));
    }
}