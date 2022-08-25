/*
 * 0949-largest-time-for-given-digits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/08/25
 */
public class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int[] counts = new int[10];
        for (int n : arr) {
            counts[n]++;
        }
        for (int h = 23; h >= 0; h--) {
            int h1 = h / 10;
            if (counts[h1] < 1) {
                continue;
            }
            counts[h1]--;

            int h2 = h % 10;
            if (counts[h2] < 1) {
                counts[h1]++;
                continue;
            }
            counts[h2]--;
            for (int m = 59; m >= 0; m--) {
                int m1 = m / 10;
                if (counts[m1] < 1) {
                    continue;
                }
                counts[m1]--;

                int m2 = m % 10;
                if (counts[m2] > 0) {
                    return String.format("%02d:%02d", h, m);
                }
                counts[m1]++;
            }
            counts[h2]++;
            counts[h1]++;
        }
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "23:41"
        System.out.println(s.largestTimeFromDigits(new int[] {1,2,3,4}));
        // ""
        System.out.println(s.largestTimeFromDigits(new int[] {5, 5, 5, 5}));
        // "05:50"
        System.out.println(s.largestTimeFromDigits(new int[] {0, 5, 0, 5}));
    }
}