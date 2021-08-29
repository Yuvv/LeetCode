/*
 * 0330-patching-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/29
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        long max = 0L;
        int patchCount = 0;
        for (int i = 0; i < nums.length && max < n; /** nothing to do */) {
            if (nums[i] > max + 1) {
                // let's patch
                max += max + 1;
                patchCount++;
            } else {
                max += nums[i];
                i++;
            }
        }
        while (max < n) {
            max += max + 1;
            patchCount++;
        }

        return patchCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "1"
        System.out.println(s.minPatches(new int[]{1, 3}, 6));
        // "2"
        System.out.println(s.minPatches(new int[]{1,5,10}, 20));
        // "0"
        System.out.println(s.minPatches(new int[]{1,2,2}, 5));
        // "3"
        System.out.println(s.minPatches(new int[]{1,2,4,6,8}, 90));
        // "2"
        System.out.println(s.minPatches(new int[]{1,7,21,31,34,37,40,43,49,87,90,92,93,98,99}, 12));
    }
}