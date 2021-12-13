/*
 * 1759-count-number-of-homogenous-substrings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/13
 */
public class Solution {
    public int countHomogenous(String s) {
        long sum = 0L;
        int i = 0;
        for (int j = 1; j <= s.length(); j++) {
            char ch = s.charAt(i);
            while (j < s.length() && s.charAt(j) == ch) {
                j++;
            }

            int len = j - i;
            sum += (len + 1) * len / 2;
            sum %= 1000000007;
            i = j;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.countHomogenous("abbcccaa"));
        // 2
        System.out.println(s.countHomogenous("xy"));
        // 11111111111115
        System.out.println(s.countHomogenous("zzzzz"));
    }
}