/*
 * 2073-time-needed-to-buy-tickets.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/23
 */
public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int cnt = 0;
        for (int i = 0; i <= k; i++) {
            cnt += Math.min(tickets[i], tickets[k]);
        }
        for (int i = k + 1; i < tickets.length; i++) {
            cnt += Math.min(tickets[i], tickets[k] - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.timeRequiredToBuy(new int[] {2,3,2}, 2));
        // 8
        System.out.println(s.timeRequiredToBuy(new int[] {5,1,1,1}, 0));
    }
}