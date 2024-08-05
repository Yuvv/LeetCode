/**
 * 3208-alternating-groups-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/05
 */
public class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int cnt = 0;
        int i = 0;
        while (i < colors.length) {
            // find first window
            boolean changed = false;
            boolean find = true;
            for (int j = i + 1; j < i + k; j++) {
                if (colors[j % colors.length] == colors[(j - 1) % colors.length]) {
                    i = j;
                    find = false;
                    changed = true;
                    break;
                }
            }
            if (find) { // slide the window
                cnt++;
                for (int j = i + k; j < colors.length + k - 1; j++) {
                    if (colors[j % colors.length] != colors[(j - 1) % colors.length]) {
                        cnt++;
                        i = j + 1;
                        changed = true;
                    } else {
                        i = j;
                        changed = true;
                        break;
                    }
                }
            }
            if (!changed) {
                i++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numberOfAlternatingGroups(new int[] {0,1,0,1,0}, 3));
        // 1
        System.out.println(s.numberOfAlternatingGroups(new int[] {0,1,1}, 3));
        // 2
        System.out.println(s.numberOfAlternatingGroups(new int[] {0,1,0,0,1,0,1}, 6));
        // 0
        System.out.println(s.numberOfAlternatingGroups(new int[] {1,1,0,1}, 4));
    }
}
