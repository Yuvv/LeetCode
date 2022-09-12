/*
 * 1351-count-negative-numbers-in-a-sorted-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/12
 */
public class Solution {
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        for (int[] row : grid) {
            cnt += row.length - findFirstNegativeIdx(row);
        }
        return cnt;
    }

    private int findFirstNegativeIdx(int[] row) {
        if (row[0] < 0) {
            return 0;
        }
        if (row[row.length - 1] >= 0) {
            return row.length;
        }
        int i = 0;
        int j = row.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (row[mid] < 0) {
                j = mid - 1;
            } else if (row[mid] >= 0) {
                i = mid + 1;
            }
        }
        // i >= j
        if (i < row.length && row[i] >= 0) {
            return i + 1;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.countNegatives(
            new int[][] {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
            }
        ));
        // 0
        System.out.println(s.countNegatives(
            new int[][] {
                {3,2}, {1,0}
            }
        ));
        // 6
        System.out.println(s.countNegatives(
            new int[][] {
                {3,2,1},
                {3,2,0},
                {3,2,-1},
                {3,-2,-4},
                {-3,-6,-9}
            }
        ));
    }
}