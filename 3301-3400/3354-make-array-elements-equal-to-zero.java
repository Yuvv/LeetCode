/**
 * 3354-make-array-elements-equal-to-zero.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/17
 */
public class Solution {
    public int countValidSelections(int[] nums) {
        int res = 0;
        int y = 0;
        for (int n : nums) {
            y += n;
        }
        int x = 0;
        for (int n : nums) {
            if (n == 0) {
                if (x == y) {
                    res += 2;
                } else if (x - y == 1) {
                    res += 1;
                } else if (x - y == -1) {
                    res += 1;
                }
            } else {
                x += n;
                y -= n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countValidSelections(new int[] {1,0,2,0,3}));
        // 0
        System.out.println(s.countValidSelections(new int[] {2,3,4,0,4,1,0}));
    }
}
