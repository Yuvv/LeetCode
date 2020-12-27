import java.util.*;

/*
 * 0085-maximal-rectangle.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/12/06
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[] hist = new int[colCount];
        LinkedList<List<Integer>> stack = new LinkedList<>();
        int maxVal = 0;

        // init hist
        for (int i = 0; i < colCount; i++) {
            hist[i] = 0;
        }
        // scan other rows
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                // 当前层为 0 的直接置为当前层的值
                if (matrix[i][j] == '0') {
                    hist[j] = matrix[i][j] - '0';
                } else {
                    hist[j] += matrix[i][j] - '0';
                }
                // 如果最后一个元素大于当前元素，则逐个弹出，确保stack是非递减的
                while (!stack.isEmpty() && stack.peek().get(1) > hist[j]) {
                    List<Integer> lastPair = stack.pop();
                    int beginIdx = lastPair.get(0);
                    while (!stack.isEmpty() && stack.peek().get(1).equals(lastPair.get(1))) {
                        List<Integer> curPair = stack.pop();
                        beginIdx = curPair.get(0);
                    }
                    maxVal = Math.max(maxVal, lastPair.get(1) * (j - beginIdx));
                    if (stack.isEmpty()) {
                        stack.push(Arrays.asList(0, hist[j]));
                    } else if (stack.peek().get(1) < hist[j]) {
                        stack.push(Arrays.asList(stack.peek().get(0) + 1, hist[j]));
                    }
                }
                stack.push(Arrays.asList(j, hist[j]));
            }
            // 此时如果不为空，则弹出所有，计算最大值
            while (!stack.isEmpty()) {
                List<Integer> lastPair = stack.pop();
                int beginIdx = lastPair.get(0);
                while (!stack.isEmpty() && stack.peek().get(1).equals(lastPair.get(1))) {
                    List<Integer> curPair = stack.pop();
                    beginIdx = curPair.get(0);
                }
                maxVal = Math.max(maxVal, lastPair.get(1) * (colCount - beginIdx));
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        // init solution
        Solution s = new Solution();
        // build matrix case 1
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        // 6 expected
        System.out.println(s.maximalRectangle(matrix));
    }
}