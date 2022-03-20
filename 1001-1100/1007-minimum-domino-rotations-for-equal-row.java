import java.util.*;

/*
 * 1007-minimum-domino-rotations-for-equal-row.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/20
 */
public class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] topCount = new int[6][2]; // 0->count, 1-> idx;
        int[] bottomCount = new int[6];
        for (int i = 0; i < topCount.length; i++) {
            topCount[i][1] = i;
        }

        for (int i = 0; i < tops.length; i++) {
            topCount[tops[i] - 1][0]++;
            bottomCount[bottoms[i] - 1]++;
        }

        int minSwap = tops.length + 1;
        Arrays.sort(topCount, Comparator.comparingInt(x -> x[0]));
        for (int[] each : topCount) {
            int tCnt = each[0];
            int bCnt = bottomCount[each[1]];
            int targetVal = each[1] + 1;
            if (tCnt + bCnt >= tops.length) {
                if (tops.length - tCnt < minSwap && isOk(tops, bottoms, targetVal)) {
                    minSwap = tops.length - tCnt;
                }
                if (tops.length - bCnt < minSwap && isOk(bottoms, tops, targetVal)) {
                    minSwap = tops.length - bCnt;
                }
            }
        }
        if (minSwap > tops.length) {
            return -1;
        }
        return minSwap;
    }

    private boolean isOk(int[] tops, int[] bottoms, int targetVal) {
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != targetVal) {
                if (bottoms[i] != targetVal) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minDominoRotations(
            new int[] {2,1,2,4,2,2},
            new int[] {5,2,6,2,3,2}
        ));
        // -1
        System.out.println(s.minDominoRotations(
            new int[] {3,5,1,2,3},
            new int[] {3,6,3,3,4}
        ));
    }
}