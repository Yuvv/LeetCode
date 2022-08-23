import java.util.Arrays;

/*
 * 1850-minimum-adjacent-swaps-to-reach-the-kth-smallest-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/22
 */
public class Solution {
    private void nextPermutation(char[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int lastDescendingIndex = findLastDescendingIndex(nums);
        if (lastDescendingIndex == -1) {
            Arrays.sort(nums);
        } else {
            int lastMinIndex = findLastMin(nums, lastDescendingIndex);
            char temp = nums[lastDescendingIndex];
            nums[lastDescendingIndex] = nums[lastMinIndex];
            nums[lastMinIndex] = temp;
            Arrays.sort(nums, lastDescendingIndex + 1, nums.length);
        }
    }

    /**
     * 逆序查找最先开始降序的位置
     *
     * @param nums 数组
     * @return 降序位置较小数的索引
     */
    private int findLastDescendingIndex(char[] nums) {
        int lastIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                lastIndex = i - 1;
                break;
            }
        }
        return lastIndex;
    }

    /**
     * 顺序查找从降序位置开始的最小的值（不能跟降序位置相等）
     *
     * @param nums                数组
     * @param lastDescendingIndex 降序位置索引
     * @return 右边最小值
     */
    private int findLastMin(char[] nums, int lastDescendingIndex) {
        int lastMinIndex = lastDescendingIndex + 1;
        int min = Integer.MAX_VALUE;
        for (int i = lastDescendingIndex + 1; i < nums.length; i++) {
            if (nums[i] < min && nums[i] > nums[lastDescendingIndex]) {
                min = nums[i];
                lastMinIndex = i;
            }
        }
        return lastMinIndex;
    }

    public int getMinSwaps(String num, int k) {
        char[] nums = num.toCharArray();
        for (int i = 0; i < k; i++) {
            nextPermutation(nums);
        }
        System.out.println(new String(nums));
        // move to right position
        int count = 0;
        char[] originNums = num.toCharArray();
        int oi = 0;
        for (int i = 0; i < nums.length; i++) {
            while (oi < nums.length && originNums[oi] == '\0') {
                oi++;
            }
            if (originNums[oi] == nums[i]) {
                oi++;
                continue;
            }
            // find first nums[i]
            int j;
            for (j = oi + 1; j < nums.length; j++) {
                while (j < nums.length && originNums[j] == '\0') {
                    j++;
                }
                if (j >= nums.length) {
                    break;
                }
                count++;
                if (originNums[j] == nums[i]) {
                    originNums[j] = '\0';
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 11
        System.out.println(s.getMinSwaps("12345642319865132185784131", 555));
        // 2
        System.out.println(s.getMinSwaps("5489355142", 4));
        // 4
        System.out.println(s.getMinSwaps("11112", 4));
        // 1
        System.out.println(s.getMinSwaps("00123", 1));
    }
}

/**
5489355421
21111
00132
12345642319865132311781485
12345642319865132185813417


12345642319865132185784131
12345642319865132188315174



 */