/*
 * 2496-maximum-value-of-a-string-in-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/01
 */
public class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String s : strs) {
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    cur = cur * 10 + (s.charAt(i) - '0');
                } else {
                    cur = s.length();
                    break;
                }
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.maximumValue(
            new String[] {"alic3","bob","3","4","00000"}
        ));
    }
}