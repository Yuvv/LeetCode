/**
 * 2706-buy-two-chocolates
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/23
 */
public class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = Math.min(prices[0], prices[1]);
        int min2 = Math.max(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < min1) {
                min2 = min1;
                min1 = prices[i];
            } else if (prices[i] < min2) {
                min2 = prices[i];
            }
        }
        if (min1 + min2 <= money) {
            return money - min1 - min2;
        }
        return money;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0
        System.out.println(s.buyChoco(new int[] { 1, 2, 2 }, 3));
        // 3
        System.out.println(s.buyChoco(new int[] { 3, 2, 3 }, 3));
    }
}
