/*
 * 2437-number-of-valid-clock-times.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/15
 */
public class Solution {
    public int countTime(String time) {
        int hTime = 1;
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') {
                hTime = 24;
            } else if (time.charAt(1) < '4') {
                hTime = 3;
            } else {
                hTime = 2;
            }
        } else if (time.charAt(1) == '?') {
            if (time.charAt(0) == '2') {
                hTime = 4;
            } else {
                hTime = 10;
            }
        }
        int mTime = 1;
        if (time.charAt(3) == '?') {
            if (time.charAt(4) == '?') {
                mTime = 60;
            } else {
                mTime = 6;
            }
        } else if (time.charAt(4) == '?') {
            mTime = 10;
        }

        return hTime * mTime;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countTime("?5:00"));
        // 100
        System.out.println(s.countTime("0?:0?"));
        // 1440
        System.out.println(s.countTime("??:??"));
    }
}