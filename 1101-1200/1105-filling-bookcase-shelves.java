/**
 * 1105-filling-bookcase-shelves.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/31
 */
public class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length+1];
        for (int i = 1; i <= books.length; i++) {
            int w = books[i-1][0];
            int h = books[i-1][1];
            dp[i] = dp[i-1] + h;
            for (int j = i - 1; j > 0; j--) {
                w += books[j - 1][0];
                if (w > shelfWidth) {
                    break;
                }
                h = Math.max(h, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + h);
            }
        }
        return dp[books.length];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.minHeightShelves(
            new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4
        ));
        // 4
        System.out.println(s.minHeightShelves(
            new int[][]{{1,3}, {2,4}, {3,2}}, 6
        ));
    }
}
