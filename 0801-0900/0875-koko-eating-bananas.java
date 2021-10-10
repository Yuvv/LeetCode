import java.util.Arrays;

/*
 * 0875-koko-eating-bananas.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/09
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxP = piles[0];
        long sumP = 0L;
        for (int pile : piles) {
            maxP = Math.max(maxP, pile);
            sumP += pile;
        }

        // binary search
        int low = (int) ((sumP - 1) / h + 1);
        int high = maxP;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isPossible(int[] piles, int k, int h) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile - 1) / k + 1;
        }
        return sum <= h;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.minEatingSpeed(new int[] {3, 6, 7, 11}, 8));
        // 30
        System.out.println(s.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 5));
        // 23
        System.out.println(s.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6));
    }
}