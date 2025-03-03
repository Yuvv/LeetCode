/**
 * 2337-move-pieces-to-obtain-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/03/03
 */
public class Solution {
    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;
        while (i < start.length() || j < target.length()) {
            while (i < start.length() && start.charAt(i) == '_') {
                i++;
            }
            while (j < target.length() && target.charAt(j) == '_') {
                j++;
            }
            if (i == start.length() && j == target.length()) {
                return true;
            } else if (i == start.length() || j == target.length()) {
                return false;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                // L can only move to left, so i must gte j
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                // R can only move to right, so i must lte j
                return false;
            }
            if (i < target.length()) {
                i++;
            }
            if (j < target.length()) {
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canChange("_L__R__R_", "L______RR"));
        // false
        System.out.println(s.canChange("R_L_", "__LR"));
        // false
        System.out.println(s.canChange("_R", "R_"));
        // false
        System.out.println(s.canChange("_L", "LR"));
    }
}
