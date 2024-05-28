/**
 * 1208-get-equal-substrings-within-budget.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/28
 */
public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = 0;
        int cost = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            cost += Math.abs(s.charAt(j) - t.charAt(j));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            len = Math.max(len, j - i + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.equalSubstring("abcd", "bcdf", 3));
        // 1
        System.out.println(s.equalSubstring("abcd", "cdef", 3));
        // 1
        System.out.println(s.equalSubstring("abcd", "acde", 0));
    }
}