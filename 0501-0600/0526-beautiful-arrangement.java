import java.util.List;
import java.util.ArrayList;

/*
 * 0526-beautiful-arrangement.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/17
 */
public class Solution {
    public int countArrangement(int n) {
        List<Integer> lst = new ArrayList<>();
        lst.add(0);

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        permute(nums, 0, lst);

        return lst.get(0);
    }

    public void permute(int[] nums, int idx, List<Integer> lst) {
        if (idx >= nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (!isBeautiful(nums, i)) {
                    return;
                }
            }
            lst.set(0, lst.get(0) + 1);
        }

        for (int i = idx; i < nums.length; i++) {
            if (i == idx) {
                permute(nums, idx + 1, lst);
            } else {
                swap(nums, i, idx);
                if (isBeautiful(nums, idx)) {
                    permute(nums, idx + 1, lst);
                }
                swap(nums, i, idx);
            }
        }
    }

    public boolean isBeautiful(int[] nums, int idx) {
        if (idx >= nums.length) {
            return true;
        }
        return nums[idx] % (idx + 1) == 0 || (idx + 1) % nums[idx] == 0;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countArrangement(2));
        // 1
        System.out.println(s.countArrangement(1));
        // 41
        System.out.println(s.countArrangement(7));
        // 24679
        System.out.println(s.countArrangement(15));
    }
}