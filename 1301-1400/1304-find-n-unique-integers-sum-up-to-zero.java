/*
 * 1304-find-n-unique-integers-sum-up-to-zero.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/15
 */
public class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 1) {
            res[--n] = 0;
        }
        int i = 1;
        while (n > 0) {
            res[--n] = i;
            res[--n] = -i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(java.util.Arrays.toString(s.sumZero(5)));
        System.out.println(java.util.Arrays.toString(s.sumZero(4)));
    }
}