/*
 * 0668-kth-smallest-number-in-multiplication-table.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/16
 */
public class Solution {
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (enough(mid, m, n, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.findKthNumber(3, 3, 5));
        // 6
        System.out.println(s.findKthNumber(2, 3, 6));
    }
}