/*
 * 1551-minimum-operations-to-make-array-equal.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/27
 */
public class Solution {
    public int minOperations(int n) {
        int x = n / 2;
        return x * (x + (n % 2 == 0 ? 0 : 1));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minOperations(3));
        // 9
        System.out.println(s.minOperations(6));
    }
}