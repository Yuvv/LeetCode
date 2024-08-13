import java.util.*;

/**
 * 3184-count-pairs-that-form-a-complete-day-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/13
 */
public class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int cnt = 0;
        for (int i = 1; i < hours.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countCompleteDayPairs(new int[] {12,12,30,24,24}));
        // 3
        System.out.println(s.countCompleteDayPairs(new int[] {72,48,24,3}));
    }
}
