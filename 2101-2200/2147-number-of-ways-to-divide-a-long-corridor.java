/**
 * 2147-number-of-ways-to-divide-a-long-corridor
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/28
 */
public class Solution {
    public static final long MOD = 1000000007L;

    public int numberOfWays(String corridor) {
        // trim 'P'
        int i = 0, j = corridor.length() - 1;
        while (i < corridor.length() && corridor.charAt(i) == 'P') {
            i++;
        }
        while (j >= 0 && corridor.charAt(j) == 'P') {
            j--;
        }
        if (j <= i) {
            return 0;
        }

        long res = 1L;
        int sc = 0, nextsc = 2;
        for (int k = i; k <= j; k++) {
            if (corridor.charAt(k) == 'S') {
                sc++;
            }
            if (sc == nextsc) {
                nextsc += 2;
                int m = k + 1;
                while (m < j && corridor.charAt(m) == 'P') {
                    m++;
                }
                //System.out.println(corridor + ": m=" + m + ", k=" + k);
                res *= m - k;
                res %= MOD;
                k = m - 1;
            }
        }
        if (sc % 2 == 1) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numberOfWays("SSPPSPS"));
        // 1
        System.out.println(s.numberOfWays("PPSPSP"));
        // 0
        System.out.println(s.numberOfWays("S"));
    }
}
