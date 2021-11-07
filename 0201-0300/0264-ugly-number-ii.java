/*
 * 0264-ugly-number-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/07
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int a2 = 0, a3 = 0, a5 = 0;
        for (int i = 1; i < n; i++) {
            int b2 = arr[a2] * 2;
            int b3 = arr[a3] * 3;
            int b5 = arr[a5] * 5;
            int res = Math.min(b2, Math.min(b3, b5));
            arr[i] = res;
            if (res == b2) {
                a2++;
            }
            if (res == b3) {
                a3++;
            }
            if (res == b5) {
                a5++;
            }
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.nthUglyNumber(10));
        // 1
        System.out.println(s.nthUglyNumber(1));
    }
}