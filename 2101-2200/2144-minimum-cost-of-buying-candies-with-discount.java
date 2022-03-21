import java.util.Arrays;

/*
 * 2144-minimum-cost-of-buying-candies-with-discount.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/21
 */
public class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int i;
        for (i = cost.length - 1; i - 2 >= 0; i -= 3) {
            sum += cost[i];
            sum += cost[i - 1];
        }
        while (i >= 0) {
            sum += cost[i];
            i--;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minimumCost(new int[] {1,2,3}));
        // 23
        System.out.println(s.minimumCost(new int[] {6,5,7,9,2,2}));
        // 10
        System.out.println(s.minimumCost(new int[] {5,5}));
        // 5
        System.out.println(s.minimumCost(new int[] {5}));
    }
}