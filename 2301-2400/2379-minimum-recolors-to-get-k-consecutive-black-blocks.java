/**
 * 2379-minimum-recolors-to-get-k-consecutive-black-blocks.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/03/08
 */
public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wCnt = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                wCnt++;
            }
        }
        int minCnt = wCnt;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                wCnt--;
            }
            if (blocks.charAt(i) == 'W') {
                wCnt++;
            }
            minCnt = Math.min(minCnt, wCnt);
        }
        return minCnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minimumRecolors("WBBWWBBWBW", 7));
        // 0
        System.out.println(s.minimumRecolors("WBWBBBW", 2));
    }
}
