import java.util.*;
import java.util.stream.Collectors;

/*
 * 0442-find-all-duplicates-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/31
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i) {
                int tmp = nums[nums[i] - 1];
                if (tmp == nums[i]) {
                    break;
                }
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                resList.add(nums[i]);
            }
        }
        return resList;
    }
    // AC but not good
    public List<Integer> findDuplicates_hashmap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return map.entrySet().stream()
            .filter(e -> e.getValue().intValue() == 2)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // [2,3]
        System.out.println(s.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        // [1]
        System.out.println(s.findDuplicates(new int[]{1,1,2}));
        // []
        System.out.println(s.findDuplicates(new int[]{1}));

    }
}