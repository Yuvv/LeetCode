/*
 * 1422-maximum-score-after-splitting-a-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/23
 */
public class Solution {
    public int maxScore(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, left + right);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.maxScore("011101"));
        // 5
        System.out.println(s.maxScore("00111"));
        // 3
        System.out.println(s.maxScore("1111"));
    }
}