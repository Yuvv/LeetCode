import java.util.Arrays;
/**
 * 3075-maximize-happiness-of-selected-children.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/11
 */
public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0L;
        int base = 0;
        int j = happiness.length - 1;
        while (k > 0) {
            res += Math.max(0, happiness[j] - base);
            j--;
            base++;
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.maximumHappinessSum(new int[]{1,1,1,1}, 2));
        // 4
        System.out.println(s.maximumHappinessSum(new int[]{1,2,3}, 2));
    }
}