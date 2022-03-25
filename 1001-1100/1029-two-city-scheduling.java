import java.util.Arrays;

/*
 * 1029-two-city-scheduling.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/25
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            int x = Math.abs(a[0] - a[1]);
            int y = Math.abs(b[0] - b[1]);
            return -Integer.compare(x, y);
        });
        int n = costs.length / 2;
        int sum = 0;
        int ac = 0, bc = 0;
        for (int[] abcost : costs) {
            if (abcost[0] > abcost[1]) {
                if (bc < n) {
                    // -> b
                    bc++;
                    sum += abcost[1];
                } else {
                    // -> a
                    ac++;
                    sum += abcost[0];
                }
            } else {
                if (ac < n) {
                    // -> a
                    ac++;
                    sum += abcost[0];
                } else {
                    // -> b
                    bc++;
                    sum += abcost[1];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 110
        System.out.println(s.twoCitySchedCost(new int[][] {
            {10,20}, {30,200}, {400,50}, {30,20}
        }));
        // 1859
        System.out.println(s.twoCitySchedCost(new int[][] {
            {259,770}, {448,54}, {926,667}, {184,139}, {840,118}, {577,469}
        }));
        // 3086
        System.out.println(s.twoCitySchedCost(new int[][] {
            {515,563}, {451,713}, {537,709}, {343,819}, {855,779},
            {457,60}, {650,359}, {631,42}
        }));
    }
}