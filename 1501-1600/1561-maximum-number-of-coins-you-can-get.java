import java.util.Arrays;

/**
 * 1561-maximum-number-of-coins-you-can-get.java
 *
 * @date 2024/1/27
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = 0, j = piles.length-1;
        int res = 0;
        while (i < j) {
            res += piles[j-1];
            i++;
            j-=2;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 18
        System.out.println(s.maxCoins(new int[]{9,8,7,6,1,2,3,4,5}));
    }
}
