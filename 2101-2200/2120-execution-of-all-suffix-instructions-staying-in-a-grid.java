import java.util.Arrays;

/*
 * 2120-execution-of-all-suffix-instructions-staying-in-a-grid.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/09
 */
public class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int[] pt = new int[] {startPos[1], startPos[0]};
            int count = 0;
            for (int j = i; j < m; j++) {
                char ch = s.charAt(j);
                if (ch == 'U') {
                    pt[1] -= 1;
                } else if (ch == 'D') {
                    pt[1] += 1;
                } else if (ch == 'L') {
                    pt[0] -= 1;
                } else if (ch == 'R') {
                    pt[0] += 1;
                }
                if (pt[0] < 0 || pt[1] < 0 || pt[0] >= n || pt[1] >= n) {
                    break;
                }
                count++;
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,5,4,3,1,0]
        System.out.println(Arrays.toString(s.executeInstructions(3, new int[] {0,1}, "RRDDLU")));
        // [4,1,0,0]
        System.out.println(Arrays.toString(s.executeInstructions(2, new int[] {1,1}, "LURD")));
        // [0,0,0,0]
        System.out.println(Arrays.toString(s.executeInstructions(1, new int[] {0,0}, "LRUD")));
    }
}