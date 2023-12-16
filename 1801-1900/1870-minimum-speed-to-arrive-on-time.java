/**
 * 1870-minimum-speed-to-arrive-on-time
 *
 * @authro Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/16
 */
public class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 + 0.01D > hour) {
            return -1;
        }
        int max = dist[0];
        for (int i = 1; i < dist.length; i++) {
            max = Math.max(max, dist[i]);
        }
        max = max * 100;
        int min = 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (check(dist, mid, hour)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        if (check(dist, min, hour)) { // you need to check it again
            return min;
        }
        return min+1;
    }

    private boolean check(int[] dist, int mid, double hour) {
        double total = 0.0;
        boolean ok = true;
        for (int i = 0; i < dist.length-1; i++) {
            total += Math.ceil((double) dist[i] / mid);
            if (total > hour) {
                ok = false;
                break;
            }
        }
        if (ok) {
            total += (double)dist[dist.length-1]/mid;
            ok = total <= hour;
        }
        return ok;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minSpeedOnTime(
                new int[] { 1, 3, 2 }, 6));
        // 3
        System.out.println(s.minSpeedOnTime(
                new int[] { 1, 3, 2 }, 2.7));
        // -1
        System.out.println(s.minSpeedOnTime(
                new int[] { 1, 3, 2 }, 1.9));
        // 10000000
        System.out.println(s.minSpeedOnTime(
                new int[] {1,1,100000}, 2.01));
        // 5000000
        System.out.println(s.minSpeedOnTime(
                new int[] {1,1,100000}, 2.02));
    }
}
