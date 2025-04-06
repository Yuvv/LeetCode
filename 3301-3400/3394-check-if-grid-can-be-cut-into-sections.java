import java.util.*;
/**
 * 3394-check-if-grid-can-be-cut-into-sections.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/06
 */
public class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        // sort by x-direction
        Arrays.sort(rectangles, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[2] - b[2];
        });
        List<int[]> xCuts = new ArrayList<>(4);
        int[] lastSpan = new int[]{rectangles[0][0], rectangles[0][2]};
        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i][2] <= lastSpan[1]) {
                lastSpan[1] = Math.max(lastSpan[1], rectangles[i][2]);
            } else if (rectangles[i][0] < lastSpan[1]) {
                lastSpan[1] = rectangles[i][2];
            } else {
                xCuts.add(lastSpan);
                lastSpan = new int[]{rectangles[i][0], rectangles[i][2]};
            }
            if (xCuts.size() > 2 || i == rectangles.length - 1 && xCuts.size() == 2) {
                return true;
            }
        }
        // sort by y-direction
        Arrays.sort(rectangles, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[3] - b[3];
        });
        List<int[]> yCuts = new ArrayList<>(4);
        lastSpan = new int[]{rectangles[0][1], rectangles[0][3]};
        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i][3] <= lastSpan[1]) {
                lastSpan[1] = Math.max(lastSpan[1], rectangles[i][3]);
            } else if (rectangles[i][1] < lastSpan[1]) {
                lastSpan[1] = rectangles[i][3];
            } else {
                yCuts.add(lastSpan);
                lastSpan = new int[]{rectangles[i][1], rectangles[i][3]};
            }
            if (yCuts.size() > 2 || i == rectangles.length - 1 && yCuts.size() == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.checkValidCuts(
            5,
            new int[][]{
                {1, 0, 5, 2},
                {0, 2, 2, 4},
                {3, 2, 5, 3},
                {3, 2, 5, 3},
                {0, 4, 4, 5}
            }
        ));
    }
}
