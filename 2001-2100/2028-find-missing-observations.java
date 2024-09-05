/**
 * 2028-find-missing-observations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/05
 */
public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int total = mean * (rolls.length + n);
        for (int r : rolls) {
            total -= r;
        }
        mean = total/n;
        total -= mean*n;
        if (mean > 6 || mean==6 && total>0) {
            return new int[0];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = mean;
            if (total > 0) {
                res[i]++;
                total--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [6,6]
        System.out.println(s.missingRolls(new int[] {3,2,4,3}, 4, 2));
        // [2,3,2,2]
        System.out.println(s.missingRolls(new int[] {1,5,6}, 3, 4));
        // []
        System.out.println(s.missingRolls(new int[] {1,2,3,4}, 6, 4));
    }
}
