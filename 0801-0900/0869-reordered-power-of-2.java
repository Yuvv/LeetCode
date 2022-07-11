/*
 * 0869-reordered-power-of-2.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/11
 */
public class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] nr = count(n);
        for (int i = 0; i < 30; i++) {
            if (java.util.Arrays.equals(count(1 << i), nr)) {
                return true;
            }
        }
        return false;
    }

    private int[] count(int n) {
        int[] res = new int[10];
        while (n > 0) {
            int val = n % 10;
            n /= 10;
            res[val]++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true;
        System.out.println(s.reorderedPowerOf2(1));
        // false
        System.out.println(s.reorderedPowerOf2(10));
    }
}