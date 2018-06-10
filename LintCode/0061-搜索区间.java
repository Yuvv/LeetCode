/**
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 * 如果目标值不在数组中，则返回[-1, -1]
 * eg)
 * 给出[5, 7, 7, 8, 8, 10]和目标值target=8, 返回[3, 4]
 */

public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int start = -1;
        int end = -1;
        
        if (A.length == 0) {
            return new int[]{start, end};
        }
        
        start = binarySearch(A, target, 0, A.length - 1, -1);
        end = binarySearch(A, target, 0, A.length - 1, 1);
        
        return new int[]{start, end};
    }
    
    public int binarySearch(int[] A, int target, int left, int right, int side) {
        // side = 1 为右边，side = -1 为左边
        if (left > right) {
            return -1;
        } else if (right - left == 1) {
            if (A[left] == target) {
                if (side == 1) {
                    if (A[right] == target) {
                        return right;
                    }
                }
                return left;
            } else if (A[right] == target) {
                return right;
            } else {
                return -1;
            }
        }

        int mid = (left + right) / 2;

        if (A[mid] > target) {
            return binarySearch(A, target, left, mid - 1, side);
        } else if (A[mid] < target) {
            return binarySearch(A, target, mid + 1, right, side);
        } else {
            if (side == 1 && mid + 1 < A.length && A[mid + 1] == target) {
                return binarySearch(A, target, mid + 1, right, side);
            } else if (side == -1 && mid - 1 >= 0 && A[mid - 1] == target) {
                return binarySearch(A, target, left, mid - 1, side);
            } else {
                return mid;
            }
        }
    }
}