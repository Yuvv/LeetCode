/*
 * 1423-maximum-points-you-can-obtain-from-cards.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/26
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int i = 1; i <= k; i++) {
            sum -= cardPoints[k - i];
            sum += cardPoints[cardPoints.length - i];

            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 12
        System.out.println(s.maxScore(
            new int[] {1,2,3,4,5,6,1}, 3
        ));
    }
}