import java.util.Set;
import java.util.HashSet;

/*
 * 0888-fair-candy-swap.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/14
 */
public class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> as = new HashSet<>(aliceSizes.length);
        Set<Integer> bs = new HashSet(bobSizes.length);
        int aSum = 0;
        int bSum = 0;

        for (int a : aliceSizes) {
            as.add(a);
            aSum += a;
        }
        for (int b : bobSizes) {
            bs.add(b);
            bSum += b;
        }

        for (Integer a : as) {
            int target = (bSum - aSum) / 2 + a;
            if (bs.contains(target)) {
                return new int[] {a, target};
            }
        }

        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2]
        System.out.println(s.fairCandySwap(new int[] {1,1}, new int[]{2,2}));
        // [1,2]
        System.out.println(s.fairCandySwap(new int[] {1,2}, new int[]{2,3}));
        // [2,3]
        System.out.println(s.fairCandySwap(new int[] {2}, new int[]{1,3}));
        // [5,4]
        System.out.println(s.fairCandySwap(new int[] {1,2,5}, new int[]{2,4}));
    }
}