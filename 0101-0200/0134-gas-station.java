/*
 * 0134-gas-station.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/07/19
 */
public class Solution {
    public int canCompleteCircuit_on2(int[] gas, int[] cost) {
        int i, j, k;
        // 逐个位置尝试，找到了就直接返回
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

    // 两指针碰撞 - 这种方式其实并不在乎指针的初始位置，只要过程最终能保证跑完全程就行
    int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                // 如果当前还充足，就继续往后面走
                sum += gas[end] - cost[end];
                end++;
            } else {
                // 当前不充足，就退后一步，加点油直到还能往后走
                start--;
                sum += gas[start] - cost[start];
            }
        }
       return sum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        // -1
        System.out.println(s.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}