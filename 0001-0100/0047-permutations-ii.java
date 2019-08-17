import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/*
 * 0047-permutations-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2019/08/17
 */
class Solution {
    List<List<Integer>> lst;
    Set<String> set;

    public List<List<Integer>> permuteUnique(int[] nums) {
        lst = new ArrayList<>();
        set = new HashSet<>();
        permuteUnique(nums, 0);

        return lst;
    }

    public void permuteUnique(int[] nums, int idx) {
        if (idx >= nums.length) {
            List<Integer> arr = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int n: nums) {
                arr.add(n);
                sb.append(n);
            }
            if (set.contains(sb.toString())) {
                return;
            } else {
                set.add(sb.toString());
            }
            lst.add(arr);
        }

        for (int i = idx; i < nums.length; i++) {
            if (i == idx) {
                permuteUnique(nums, idx + 1);
            } else {
                if (nums[i] == nums[idx]) {
                    continue;
                }
                swap(nums, i, idx);
                permuteUnique(nums, idx + 1);
                swap(nums, i, idx);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.permuteUnique(new int[]{1, 1, 2});
        System.out.println(result);

        result = s.permuteUnique(new int[]{1, 3, 5, 1});
        System.out.println(result);

        result = s.permuteUnique(new int[]{1, 3, 3, 1});
        System.out.println(result);
    }
}