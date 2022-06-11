/*
 * 1901-find-a-peak-element-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/11
 */
public class Solution {
    public int findMaxValueIdx(int[] row) {
        int maxi = 0;
        for (int i = 1; i < row.length; i++) {
            if (row[i] > row[maxi]) {
                maxi = i;
            }
        }
        return maxi;
    }

    // find any peak is ok whatever if it is the highest
    public int[] findPeakGrid(int[][] mat) {
        int rowi = 0, rowj = mat.length - 1;
        while (rowi <= rowj) {
            int mid = (rowi + rowj) / 2;
            boolean isMidMax = true;
            int midMaxI = findMaxValueIdx(mat[mid]);

            int midLeftMaxI = -1;
            boolean isMidLeftMax = false;
            if (mid > 0) {
                midLeftMaxI = findMaxValueIdx(mat[mid - 1]);
                if (mat[mid - 1][midLeftMaxI] > mat[mid][midMaxI]) {
                    isMidMax = false;
                    isMidLeftMax = true;
                }
            }

            int midRightMaxI = -1;
            boolean isMidRightMax = false;
            if (mid < mat.length - 1) {
                midRightMaxI = findMaxValueIdx(mat[mid + 1]);
                if (isMidMax) {
                    if (mat[mid + 1][midRightMaxI] > mat[mid][midMaxI]) {
                        isMidMax = false;
                        isMidRightMax = true;
                    }
                }
                if (isMidLeftMax) {
                    if (mat[mid + 1][midRightMaxI] > mat[mid - 1][midLeftMaxI]) {
                        isMidLeftMax = false;
                        isMidRightMax = true;
                    }
                }
            }

            // finally
            if (isMidMax) {
                return new int[] {mid, midMaxI};
            }
            if (isMidLeftMax) {
                rowj = mid - 1;
            } else if (isMidRightMax) {
                rowi = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [0,1]
        System.out.println(java.util.Arrays.toString(s.findPeakGrid(new int[][] {{1,4}, {3,2}})));
        // [1,1]
        System.out.println(java.util.Arrays.toString(s.findPeakGrid(new int[][] {{10,20,15}, {21,30,14}, {7,16,32}})));
    }
}