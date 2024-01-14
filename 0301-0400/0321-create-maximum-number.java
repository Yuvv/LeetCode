import java.util.*;

/*
 * 0321-create-maximum-number.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/03/26
 */
public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty()
                    && num > stack.peek()
                    && stack.size() + nums.length - i > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(num);
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public int compareArray(int[] nums1, int from1, int[] nums2, int from2) {
        int x = 0;
        while (from1 < nums1.length && from2 < nums2.length) {
            x = nums1[from1] - nums2[from2];
            if (x != 0) {
                return x;
            }
            from1++;
            from2++;
        }
        if (from1 >= nums1.length && from2 >= nums2.length) {
            return 0;
        } else if (from1 >= nums1.length) {
            return -1;
        } else {
            return 1;
        }
    }

    public int[] mergeArray(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < k; i++) {
            if (idx1 >= nums1.length) {
                res[i] = nums2[idx2];
                idx2++;
            } else if (idx2 >= nums2.length) {
                res[i] = nums1[idx1];
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                res[i] = nums1[idx1];
                idx1++;
            } else if (nums2[idx2] > nums1[idx1]) {
                res[i] = nums2[idx2];
                idx2++;
            } else { // nums1[idx1] == nums2[idx2]
                if (compareArray(nums1, idx1, nums2, idx2) > 0) {
                    res[i] = nums1[idx1];
                    idx1++;
                } else {
                    res[i] = nums2[idx2];
                    idx2++;
                }
            }
        }
        return res;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] maxRes = new int[k];
        for (int i = 0; i <= Math.min(k, nums1.length); i++) {
            int j = k - i;
            if (j > nums2.length) {
                continue;
            }
            int[] maxArr1 = mostCompetitive(nums1, i);
            int[] maxArr2 = mostCompetitive(nums2, j);
            int[] res = mergeArray(maxArr1, maxArr2, k);
            if (compareArray(maxRes, 0, res, 0) < 0) {
                maxRes = res;
            }
        }
        return maxRes;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [9,8,6,5,3]
        System.out.println(Arrays.toString(s.maxNumber(
            new int[] {3,4,6,5},
            new int[] {9,1,2,5,8,3},
            5
        )));
        // [6,7,6,0,4]
        System.out.println(Arrays.toString(s.maxNumber(
            new int[] {6,7}, new int[] {6,0,4}, 5
        )));
        // [9,8,9]
        System.out.println(Arrays.toString(s.maxNumber(
            new int[] {3,9}, new int[] {8,9}, 3
        )));
    }
}
