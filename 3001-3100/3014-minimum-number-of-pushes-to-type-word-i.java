/**
 * 3014-minimum-number-of-pushes-to-type-word-i.java
 *
 * @date 2024/2/2
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        if (len <= 8) {
            return len;
        } else if (len <= 16) {
            return (len-8)*2+8;
        } else if (len <= 24) {
            return (len-16)*3+24;
        } else {
            return (len-24)*4+48;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minimumPushes("abcde"));
        // 12
        System.out.println(s.minimumPushes("xycdefghij"));
    }
}
