/*
 * 2335-minimum-amount-of-time-to-fill-cups.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/12
 */
public class Solution {
    public int fillCups(int[] amount) {
        java.util.Arrays.sort(amount);
        int cnt = 0;

        while (amount[2] > 0 && amount[1] > 0) {
            amount[2]--;
            amount[1]--;
            cnt++;
            java.util.Arrays.sort(amount);
        }

        cnt += amount[2];

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.fillCups(new int[] {1,4,2}));
        // 7
        System.out.println(s.fillCups(new int[] {5,4,4}));
        // 5
        System.out.println(s.fillCups(new int[] {5,2,3}));
    }
}