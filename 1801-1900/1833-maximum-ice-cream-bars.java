/*
 * 1833-maximum-ice-cream-bars.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/29
 */
public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        java.util.Arrays.sort(costs);
        int i = 0;
        int sum = 0;
        for (i = 0; i < costs.length; i++) {
            sum += costs[i];
            if (sum > coins) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maxIceCream(new int[] {1,3,2,4,1}, 7));
        // 0
        System.out.println(s.maxIceCream(new int[] {10,6,8,7,7,8}, 5));
    }
}