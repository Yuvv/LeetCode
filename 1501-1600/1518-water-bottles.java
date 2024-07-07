/**
 * 1518-water-bottles.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/07
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        while (numBottles >= numExchange) {
            int change = numBottles / numExchange;
            numBottles = numBottles % numExchange + change;
            res += change * numExchange;
        }
        res += numBottles;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 13
        System.out.println(s.numWaterBottles(9, 3));
        // 19
        System.out.println(s.numWaterBottles(15, 4));
    }
}
