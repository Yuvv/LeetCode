/**
 * 3206-alternating-groups-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/05
 */
public class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int cnt = 0;
        for (int i = 0; i < colors.length; i++) {
            int j = (i + 1) % colors.length;
            int k = (i + 2) % colors.length;
            if (colors[i] == colors[k] && colors[i] != colors[j]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.numberOfAlternatingGroups(new int[] {1,1,1}));
        // 3
        System.out.println(s.numberOfAlternatingGroups(new int[] {0,1,0,0,1}));
    }
}
