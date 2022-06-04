import java.util.LinkedList;

/*
 * 0980-unique-paths-iii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/29
 */
public class Solution {
    final static int[][] DIRECTION = new int[][] {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    public int uniquePathsIII(int[][] grid) {
        // 1 <= m*n <= 20
        LinkedList<Integer> stack = new LinkedList<>();
        int val = 0;
        int targetVal = 0;
        int startBitPos = -1;
        int targetBitPos = -1;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                int curBitPos = i * row.length + j;
                if (row[j] == 2) {
                    targetBitPos = curBitPos;
                } else if (row[j] == 1) {
                    startBitPos = curBitPos;
                    val |= 1 << curBitPos;
                } else if (row[j] == -1) {
                    val |= 1 << curBitPos;
                }
                targetVal |= 1 << curBitPos;
            }
        }
        stack.push(val);
        return walk(stack, grid.length, grid[0].length, startBitPos, targetBitPos, targetVal);
    }

    public int walk(LinkedList<Integer> stack, int m, int n, int bitPos, int targetBitPos, int targetVal) {
        if (bitPos == targetBitPos) {
            if (stack.peek() == targetVal) {
                return 1;
            } else {
                return 0;
            }
        }
        int i = bitPos / n;
        int j = bitPos % n;
        int count = 0;
        for (int[] dir : DIRECTION) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < m && jj >= 0 && jj < n) {
                int nextBitPos = ii * n + jj;
                if ((stack.peek() & (1 << nextBitPos)) == 0) {
                    int nextVal = stack.peek() | (1 << nextBitPos);
                    stack.push(nextVal);
                    count += walk(stack, m, n, nextBitPos, targetBitPos, targetVal);
                    stack.pop();
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.uniquePathsIII(new int[][] {
            {1,0,0,0},
            {0,0,0,0},
            {0,0,2,-1}
        }));
        // 0
        System.out.println(s.uniquePathsIII(new int[][] {
            {0,1},
            {2,0}
        }));
    }
}