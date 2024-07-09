/**
 * 1701-average-waiting-time.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/09
 */
public class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWait = 0D;
        int start = customers[0][0];
        for (int[] cc : customers) {
            if (cc[0] >= start) {
                start = cc[0];
            }
            start += cc[1];
            totalWait += start - cc[0];
        }
        return totalWait / customers.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5.00000
        System.out.println(s.averagewaitingtime(new int[][]{
            {1,2}, {2,5}, {4,3}
        }));
        // 3.25000
        System.out.println(s.averagewaitingtime(new int[][]{
            {5,2}, {5,4}, {10,3}, {20,1}
        }));
    }
}
