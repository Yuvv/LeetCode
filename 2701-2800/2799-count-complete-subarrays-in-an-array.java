import java.util.*;

/*
 * 2799-count-complete-subarrays-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/09/03
 */
public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // slide-window
        int count = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() == set.size()) {
                count += nums.length - i;
                Integer val = map.get(nums[j]);
                if (val == 1) {
                    map.remove(nums[j]);
                } else {
                    map.put(nums[j], val - 1);
                }
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.countCompleteSubarrays(new int[] {1,3,1,2,2}));
        // 10
        System.out.println(s.countCompleteSubarrays(new int[] {5,5,5,5}));
    }
}