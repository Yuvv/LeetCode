/**
 * 1578-minimum-time-to-make-rope-colorful
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/27
 */
public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        int i = 0;
        while (i < colors.length()) {
            char ch = colors.charAt(i);
            total += neededTime[i];
            int maxTime = neededTime[i];
            int j = i + 1;
            while (j < colors.length() && colors.charAt(j) == ch) {
                total += neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j]);
                j++;
            }
            total -= maxTime;
            i = j;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minCost("abaac", new int[] { 1, 2, 3, 4, 5 }));
        // 0
        System.out.println(s.minCost("abc", new int[] { 1, 2, 3 }));
        // 2
        System.out.println(s.minCost("aabaa", new int[] { 1, 2, 3, 4, 1 }));
    }
}
