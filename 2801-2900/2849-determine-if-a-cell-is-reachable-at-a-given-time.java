/**
 * 2849-determine-if-a-cell-is-reachable-at-a-given-time
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/18
 */
public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dis = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        if (dis == 0 && t == 1) {
            return false;
        }
        return dis <= t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isReachableAtTime(2, 4, 7, 7, 6));
        // false
        System.out.println(s.isReachableAtTime(3, 1, 7, 3, 3));
    }
}
