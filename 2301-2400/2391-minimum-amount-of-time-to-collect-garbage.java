/**
 * 2391-minimum-amount-of-time-to-collect-garbage.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/09
 */
public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int gj = -1;
        int pj = -1;
        int mj = -1;
        int res = 0;
        for (int i = 0; i < garbage.length; i++) {
            res += garbage[i].length();
            for (int j = 0; j < garbage[i].length(); j++) {
                char ch = garbage[i].charAt(j);
                if (ch == 'G') {
                    gj = i;
                } else if (ch == 'P') {
                    pj = i;
                } else { // M
                    mj = i;
                }
            }
        }
        for (int i = 0; i < travel.length; i++) {
            if (i < gj) {
                res += travel[i];
            }
            if (i < pj) {
                res += travel[i];
            }
            if (i < mj) {
                res += travel[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 21
        System.out.println(s.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[] {2,4,3}));
        // 37
        System.out.println(s.garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[] {3,10}));
    }
}
