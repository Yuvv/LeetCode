/**
 * 3582-generate-tag-for-video-caption.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/24
 */
public class Solution {
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        int i = 0;
        while (sb.length() < 100 && i < caption.length()) {
            while (i < caption.length() && caption.charAt(i) == ' ') {
                i++;
            }
            if (i >= caption.length()) {
                break;
            }
            char ch = caption.charAt(i);
            if (sb.length() == 1) {
                sb.append( Character.toLowerCase(ch) ); // to lower
            } else {
                if (i > 0 && caption.charAt(i-1) == ' ') {
                    sb.append( Character.toUpperCase(ch) );
                } else {
                    sb.append( Character.toLowerCase(ch) );
                }
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "#leetcodeDailyStreakAchieved"
        System.out.println(s.generateTag("Leetcode daily streak achieved"));
        // "#leetcodeDailyStreakStreakAchieved"
        System.out.println(s.generateTag("Leetcode DAILY  STREAK    streak achieved"));
    }
}