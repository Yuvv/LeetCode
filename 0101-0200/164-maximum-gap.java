/*
 * 164-maximum-gap.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/16
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gap = (max - min) / (nums.length - 1);
        if ((max - min) % (nums.length - 1) > 0) {
            gap++;
        }
        int[][] bucket = new int[nums.length - 1][2];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i][0] = Integer.MAX_VALUE;
            bucket[i][1] = Integer.MIN_VALUE;
        }

        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            int i = (num - min) / gap;
            bucket[i][0] = Math.min(bucket[i][0], num);
            bucket[i][1] = Math.max(bucket[i][1], num);
        }

        int maxDiff = Integer.MIN_VALUE;
        int last = min;
        for (int[] range : bucket) {
            if (range[0] == Integer.MAX_VALUE && range[1] == Integer.MIN_VALUE) {
                continue;
            }
            maxDiff = Math.max(maxDiff, range[0] - last);
            last = range[1];
        }
        maxDiff = Math.max(maxDiff, max - last);
        return maxDiff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maximumGap(new int[] {3,6,9,1}));
        // 2
        System.out.println(s.maximumGap(new int[] {1,7,6,3,2,4}));
        // 2
        System.out.println(s.maximumGap(new int[] {1,7,1,7,6,3,2,4,4,4,3}));
    }
}