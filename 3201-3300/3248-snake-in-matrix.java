import java.util.Arrays;
import java.util.List;
/**
 * 3248-snake-in-matrix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/04
 */
public class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        for (String cmd : commands) {
            switch (cmd) {
                case "DOWN":
                    i++;
                    break;
                case "UP":
                    i--;
                    break;
                case "RIGHT":
                    j++;
                    break;
                case "LEFT":
                    j--;
                    break;
                default:
                    break;
            }
        }
        return i*n + j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.finalPositionOfSnake(2, Arrays.asList("RIGHT", "DOWN")));
        // 1
        System.out.println(s.finalPositionOfSnake(3, Arrays.asList("DOWN", "RIGHT", "UP")));
    }
}
