/*
 * 1899-merge-triplets-to-form-target-triplet.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/24
 */
public class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] candidate = new int[] {0, 0, 0};
        for (int[] each : triplets) {
            if (each[0] > target[0] || each[1] > target[1] || each[2] > target[2]) {
                continue;
            }
            candidate[0] = Math.max(candidate[0], each[0]);
            candidate[1] = Math.max(candidate[1], each[1]);
            candidate[2] = Math.max(candidate[2], each[2]);
            if (candidate[0] == target[0] && candidate[1] == target[1] && candidate[2] == target[2]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.mergeTriplets(
            new int[][] {
                {2,5,3}, {1,8,4}, {1,7,5}
            },
            new int[] {2,7,5}
        ));
    }
}