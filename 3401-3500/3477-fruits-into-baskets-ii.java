/**
 * 3477-fruits-into-baskets-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/09
 */
public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt = 0;
        for (int fruit : fruits) {
            int i = 0;
            while (i < baskets.length && baskets[i] < fruit) {
                i++;
            }
            if (i < baskets.length) {
                baskets[i] = 0;
            } else {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numOfUnplacedFruits(new int[]{4,2,5}, new int[]{3,5,4}));
        // 0
        System.out.println(s.numOfUnplacedFruits(new int[]{3,6,1}, new int[]{6,4,7}));
    }
}