/*
 * 1672-richest-customer-wealth.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/26
 */
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxVal = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            maxVal = Math.max(maxVal, sum);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.maximumWealth(new int[][] {{1,2,3},{3,2,1}}));
        // 10
        System.out.println(s.maximumWealth(new int[][] {{1,5},{7,3},{2,5}}));
        // 17
        System.out.println(s.maximumWealth(new int[][] {{2,8,7},{7,1,3},{1,9,5}}));

    }
}