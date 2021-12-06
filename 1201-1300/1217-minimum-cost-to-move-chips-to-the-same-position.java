/*
 * 1217-minimum-cost-to-move-chips-to-the-same-position.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/06
 */
public class Solution {
    public int minCostToMoveChips(int[] position) {
        int oddSum = 0L;
        int evenSum = 0L;
        for (int each : position) {
            if (each % 2 == 0) {
                evenSum++;
            } else {
                oddSum++;
            }
        }
        return Math.min(oddSum, evenSum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minCostToMoveChips(new int[] {1,2,3}));
        // 2
        System.out.println(s.minCostToMoveChips(new int[] {2,2,2,3,3}));
        // 1
        System.out.println(s.minCostToMoveChips(new int[] {1,100000000}));
    }
}