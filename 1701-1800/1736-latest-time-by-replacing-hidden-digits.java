/*
 * 1736-latest-time-by-replacing-hidden-digits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/12
 */
public class Solution {
    public String maximumTime(String time) {
        char[] chs = time.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '?') {
                if (i == 0) {
                    if (chs[1] == '?') {
                        chs[i] = '2';
                    } else if (chs[1] > '3') {
                        chs[i] = '1';
                    } else {
                        chs[i] = '2';
                    }
                } else if (i == 1) {
                    if (chs[0] == '2') {
                        chs[i] = '3';
                    } else {
                        chs[i] = '9';
                    }
                } else if (i == 3) {
                    chs[i] = '5';
                } else if (i == 4) {
                    chs[i] = '9';
                }
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "23:50"
        System.out.println(s.maximumTime("2?:?0"));
        // "09:39"
        System.out.println(s.maximumTime("0?:3?"));
        // "19:22"
        System.out.println(s.maximumTime("1?:22"));
    }
}