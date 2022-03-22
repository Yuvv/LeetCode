/*
 * 1663-smallest-string-with-a-given-numeric-value.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/22
 */
public class Solution {
    public String getSmallestString(int n, int k) {
        char[] str = new char[n];
        k -= n;
        int i = n - 1;
        while (k > 0) {
            if (k > 25) {
                str[i] = 'z';
            } else {
                str[i] = (char) ('a' + k);
            }
            k -= 25;
            i--;
        }
        while (i >= 0) {
            str[i] = 'a';
            i -= 1;
        }

       return new String(str);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "aay"
        System.out.println(s.getSmallestString(3, 27));
        // "aaszz"
        System.out.println(s.getSmallestString(5, 73));
    }
}