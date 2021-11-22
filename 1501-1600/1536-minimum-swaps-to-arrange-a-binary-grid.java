import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


/*
 * 1536-minimum-swaps-to-arrange-a-binary-grid.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/22
 */
public class Solution {
    public int minSwaps(int[][] grid) {
        int[] maxRight = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            maxRight[i] = 0;
            for (int j = grid.length - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }
                maxRight[i]++;
            }
        }
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = maxRight.length - 1; i >= 0; i--) {
            boolean notOk = true;
            for (int j = 0; j < maxRight.length; j++) {
                if (set.contains(j)) {
                    continue;
                }
                if (maxRight[j] >= i) {
                    set.add(j);
                    notOk = false;
                    break;
                }
                cnt++;
            }
            if (notOk) {
                return -1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minSwaps(new int[][] {
            {0,0,1},
            {1,1,0},
            {1,0,0}
        }));
        // -1
        System.out.println(s.minSwaps(new int[][] {
            {0,1,1,0},
            {0,1,1,0},
            {0,1,1,0},
            {0,1,0,0}
        }));
        // 0
        System.out.println(s.minSwaps(new int[][] {
            {1,0,0},
            {1,1,0},
            {1,1,1}
        }));
        // 1
        System.out.println(s.minSwaps(new int[][] {
            {1,1,0},
            {1,0,1},
            {1,1,1}
        }));
    }
}