/*
 * 1764-form-array-by-concatenating-subarrays-of-another-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/28
 */
public class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        return canChoose(groups, 0, nums, 0);
    }

    public boolean canChoose(int[][] groups, int groupIdx, int[] nums, int fromIdx) {
        if (groupIdx >= groups.length) {
            return true;
        }
        if (fromIdx < 0 || fromIdx >= nums.length) {
            return false;
        }
        int[] group = groups[groupIdx];
        while (fromIdx < nums.length - group.length + 1) {
            boolean ok = true;
            for (int i = 0; i < group.length; i++) {
                if (group[i] != nums[fromIdx + i]) {
                    ok = false;
                    break;
                }
            }
            if (ok && canChoose(groups, groupIdx + 1, nums, fromIdx + group.length)) {
                return true;
            }
            fromIdx++;
        }

        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canChoose(
            new int[][] {{1,-1,-1}, {3,-2,0}},
            new int[] {1,-1,0,1,-1,-1,3,-2,0}
        ));
        // false
        System.out.println(s.canChoose(
            new int[][] {{10,-2}, {1,2,3,4}},
            new int[] {1,2,3,4,10,-2}
        ));
        // false
        System.out.println(s.canChoose(
            new int[][] {{1,2,3}, {3,4}},
            new int[] {7,7,1,2,3,4,7,7}
        ));
    }
}