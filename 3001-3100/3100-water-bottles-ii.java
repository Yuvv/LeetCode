/**
 * 3100-water-bottles-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/02/04
 */
public class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int cnt = 0;
        while (numBottles >= numExchange) {
            cnt += numExchange;
            numBottles -= numExchange;
            numBottles++;
            numExchange++;
        }
        cnt += numBottles;
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 15
        System.out.println(s.maxBottlesDrunk(13, 6));
        // 13
        System.out.println(s.maxBottlesDrunk(10, 3));
    }
}
