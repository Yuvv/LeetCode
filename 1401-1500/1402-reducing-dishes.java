import java.util.Arrays;

/*
 * 1402-reducing-dishes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/20
 */
public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int sum = 0;
        int mulSum = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            sum += satisfaction[i];
            mulSum += (i + 1) * satisfaction[i];
        }
        int maxVal = Math.max(0, mulSum);
        for (int i = 0; i < satisfaction.length; i++) {
            mulSum -= sum;
            sum -= satisfaction[i];
            maxVal = Math.max(maxVal, mulSum);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 14
        System.out.println(s.maxSatisfaction(new int[] {-1,-8,0,5,-9}));
        // 20
        System.out.println(s.maxSatisfaction(new int[] {4,3,2}));
        // 0
        System.out.println(s.maxSatisfaction(new int[] {-1,-8,-9}));
        // 35
        System.out.println(s.maxSatisfaction(new int[] {-2,5,-1,0,3,-3}));
    }
}