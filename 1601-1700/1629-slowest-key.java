import java.util.*;

/*
 * 1629-slowest-key.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/06
 */
public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int time = 0;
        int maxTime = 0;
        char maxChar = '\0';
        for (int i = 0; i < releaseTimes.length; i++) {
            int curTime = releaseTimes[i] - time;
            if (curTime > maxTime) {
                maxTime = curTime;
                maxChar = keysPressed.charAt(i);
            } else if (curTime == maxTime && keysPressed.charAt(i) > maxChar) {
                maxChar = keysPressed.charAt(i);
            }
            time = releaseTimes[i];
        }
        return maxChar;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 'c'
        System.out.println(s.slowestKey(new int[] {9, 29, 49, 50}, "cbcd"));
        // 'a'
        System.out.println(s.slowestKey(new int[] {12,23,36,46,62}, "spuda"));
    }
}