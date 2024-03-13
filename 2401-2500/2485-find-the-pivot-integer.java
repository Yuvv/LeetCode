/**
 * 2485-find-the-pivot-integer.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/13
 */
public class Solution {
    public int pivotInteger(int n) {
        // SUM(1, x) = x*(x+1)/2
        // SUM(x, n) = (n+x)*(n-x+1)/2
        // x=SQRT( (n*n+n) / 2)
        int v = n*n+n;
        if (v % 2 != 0) {
            return -1;
        }
        v /= 2;
        int sv = (int) Math.sqrt(v);
        if (sv * sv == v) {
            return sv;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.pivotInteger(8));
        // 1
        System.out.println(s.pivotInteger(1));
        // -1
        System.out.println(s.pivotInteger(4));
    }
}