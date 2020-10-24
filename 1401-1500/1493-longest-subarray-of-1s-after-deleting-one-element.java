import java.util.*;

/*
 * 1493-longest-subarray-of-1s-after-deleting-one-element.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/10/24
 */
class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> subArrSizeList = new ArrayList<>(nums.length);
        int lastIndex = 0;
        int idx = 0;
        int maxValue = 0;
        while (idx < nums.length) {
            if (nums[idx] == 1) {
                while (idx < nums.length && nums[idx] == 1) {
                    idx++;
                }
                // 1 的用正数
                subArrSizeList.add(idx - lastIndex);
            } else {
                while (idx < nums.length && nums[idx] != 1) {
                    idx++;
                }
                // 非 1 的用负数
                subArrSizeList.add(lastIndex - idx);
            }
            lastIndex = idx;
        }

        // 找出间隔 -1 的区间
        if (subArrSizeList.size() == 1) {
            return Math.max(subArrSizeList.get(0) - 1, 0);
        } else if (subArrSizeList.size() == 2) {
            return Math.max(subArrSizeList.get(0), subArrSizeList.get(1));
        } else {
            for (int j = 2; j < subArrSizeList.size(); j++) {
                int curMax;
                if (subArrSizeList.get(j - 1) == -1) {
                    curMax = subArrSizeList.get(j - 2) + subArrSizeList.get(j);
                } else if (subArrSizeList.get(j - 1) < -1) {
                    curMax = Math.max(subArrSizeList.get(j - 2), subArrSizeList.get(j));
                } else {
                    curMax = subArrSizeList.get(j - 1);
                }
                if (curMax > maxValue) {
                    maxValue = curMax;
                }
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(3 == s.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(5 == s.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(2 == s.longestSubarray(new int[]{1,1,1}));
        System.out.println(4 == s.longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
        System.out.println(0 == s.longestSubarray(new int[]{0,0,0}));
        System.out.println(1 == s.longestSubarray(new int[]{1,0,0,0}));
    }
}