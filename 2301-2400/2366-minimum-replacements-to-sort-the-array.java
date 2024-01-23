/**
 * 2366-minimum-replacements-to-sort-the-array.java
 *
 * @date 2024/1/23
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    private int splitMin(int large, int small) {
        if (large % small == 0) {
            return small;
        }
        small--;
        int a = large % small;
        int b = large / small;
        while (a > 0 && a >= b) {
            small--;
            a = large % small;
            b = large / small;
        }
        return small;
    }

    public long minimumReplacement(int[] nums) {
        int[] rightMin = new int[nums.length];
        rightMin[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] <= rightMin[i+1]) {
                rightMin[i] = nums[i];
            } else {
                rightMin[i] = splitMin(nums[i], rightMin[i+1]);
            }
        }

        long res = 0L;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > rightMin[i+1]) {
                res += nums[i] / rightMin[i+1] - 1;
                if (nums[i] % rightMin[i+1] > 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.minimumReplacement(new int[] {1,2,3,4,5}));
        // 2
        System.out.println(s.minimumReplacement(new int[] {3,9,3}));
        // 10
        System.out.println(s.minimumReplacement(new int[] {2,9,7,7,8,13,12}));
    }
}
