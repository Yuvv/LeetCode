import java.util.*;

/*
 * 0996-number-of-squareful-arrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/12
 */
public class Solution {
    public int numSquarefulPerms(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        permuteUnique(nums, 0, set);
        return set.size();
    }

    public void permuteUnique(int[] nums, int idx, Set<String> set) {
        if (idx >= nums.length) {
            StringBuilder sb = new StringBuilder();
            int last = -1;
            for (int n : nums) {
                if (last > 0) {
                    if (!isSquareful(last + n)) {
                        return;
                    }
                }
                last = n;
                sb.append(n);
                sb.append(',');
            }
            String lstr = sb.toString();
            if (set.contains(lstr)) {
                return;
            } else {
                set.add(lstr);
            }
            return;
        }
        if (idx > 1 && !isSquareful(nums[idx - 1] + nums[idx - 2])) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i == idx) {
                permuteUnique(nums, idx + 1, set);
            } else {
                if (nums[i] == nums[idx]) {
                    continue;
                }
                swap(nums, i, idx);
                permuteUnique(nums, idx + 1, set);
                swap(nums, i, idx);
            }
        }
    }

    public boolean isSquareful(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.numSquarefulPerms(new int[] {1, 17, 8}));
        // 1
        System.out.println(s.numSquarefulPerms(new int[] {2, 2, 2}));
        // 0
        System.out.println(s.numSquarefulPerms(new int[] {75,91,39,33,39,39,69,20,43,38,48,29}));
    }
}