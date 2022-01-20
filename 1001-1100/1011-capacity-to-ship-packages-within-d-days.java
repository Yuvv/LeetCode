/*
 * 1011-capacity-to-ship-packages-within-d-days.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/20
 */
public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }
        if (days == 1) {
            return sum;
        } else if (days == weights.length) {
            return max;
        }
        int avg = sum / days + (sum % days == 0 ? 0 : 1);
        int lo = Math.max(avg, max);
        int hi = sum - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(weights, days, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public boolean isPossible(int[] weights, int days, int capacity) {
        int times = 0;
        int sum = 0;
        for (int w : weights) {
            sum += w;
            if (sum > capacity) {
                sum = w;
                times++;
            }
            if (times > days) {
                return false;
            }
        }
        if (sum > 0) {
            times++;
        }
        return times <= days;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
        // 6
        System.out.println(s.shipWithinDays(new int[] {3,2,2,4,1,4}, 3));
        // 3
        System.out.println(s.shipWithinDays(new int[] {1,2,3,1,1}, 4));
    }
}