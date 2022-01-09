/*
 * 1041-robot-bounded-in-circle.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/09
 */
public class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] pt = new int[] {0, 0};
        int[] direction = new int[] {0, 1};
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'G') {
                pt[0] += direction[0];
                pt[1] += direction[1];
            } else if (ch == 'L') {
                // turn left means direction * Matrix( [(0, 1), (-1, 0)] )
                int a = -direction[1];
                int b = direction[0];
                direction[0] = a;
                direction[1] = b;
            } else if (ch == 'R') {
                // turn right means direction * Matrix( [(0, -1), (1, 0)] )
                int a = direction[1];
                int b = -direction[0];
                direction[0] = a;
                direction[1] = b;
            }
        }

        // final vector
        if (pt[0] == 0 && pt[1] == 0) {
            return true;
        }
        if (direction[0] != 0 || direction[1] != 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isRobotBounded("GGLLGG"));
        // false
        System.out.println(s.isRobotBounded("GG"));
        // true
        System.out.println(s.isRobotBounded("GL"));
        // true
        System.out.println(s.isRobotBounded("LLGRL"));
    }
}