/*
 * 0134-gas-station.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/19
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i, j, k;
        for (i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            int totalGas = gas[i] - cost[i];
            for (j = i + 1; j < i + gas.length; j++) {
                k = j % gas.length;
                totalGas += gas[k];
                if (totalGas < cost[k]) {
                    break;
                }
                totalGas -= cost[k];
            }
            if (j == i + gas.length) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        // -1
        System.out.println(s.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}