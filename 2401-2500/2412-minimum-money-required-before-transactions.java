import java.util.Arrays;

/**
 * 2412-minimum-money-required-before-transactions
 *
 * @author Yuvv <yuvv_th@outlook.com
 * @date 2023/11/25
 */
public class Solution {
    public long minimumMoney(int[][] transactions) {
        // reverse sort by cost-cashback
        Arrays.sort(transactions, (a, b) -> {
            int as = a[0] - a[1];
            int bs = b[0] - b[1];
            if (as > 0 && bs > 0) {
                return a[1] - b[1];
            } else if (as > 0) {
                return -1;
            } else if (bs > 0) {
                return 1;
            } else {
                return b[0] - a[0];
            }
        });
        long max = 0L;
        long spend = 0L;
        for (int[] each : transactions) {
            max = Math.max(max, spend + each[0]);
            int s = each[0] - each[1];
            if (s <= 0) {
                break;
            }
            spend += s;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 10
        System.out.println(s.minimumMoney(new int[][] {
                { 2, 1 }, { 5, 0 }, { 4, 2 }
        }));
        // 3
        System.out.println(s.minimumMoney(new int[][] {
                { 3, 0 }, { 0, 3 }
        }));
    }
}
